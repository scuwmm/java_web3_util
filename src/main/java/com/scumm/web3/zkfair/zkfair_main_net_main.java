package com.scumm.web3.zkfair;

import okhttp3.OkHttpClient;
import org.apache.commons.collections4.properties.PropertiesFactory;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class zkfair_main_net_main {

    private static Web3j web3j;
    private static String NET_WORK;
    private static Long CHAIN_ID;
    private static ExecutorService executor = Executors.newFixedThreadPool(16);

    private static Map<String, Credentials> pks;

    static {
        try {
            Properties props = PropertiesFactory.INSTANCE.load("src/main/resources/zkfair.properties");
            NET_WORK = props.getProperty("NET_WORK");
            CHAIN_ID = Long.parseLong(props.getProperty("CHAIN_ID"));
//            String PRIVATE_KEYS =props.getProperty("PRIVATE_KEYS");
            pks = Arrays.asList(props.getProperty("PRIVATE_KEYS").split(","))
                    .stream().map(pk -> Credentials.create(pk))
                    .collect(Collectors.toMap(pk -> pk.getAddress(), pk -> pk));
            web3j = Web3j.build(new HttpService(NET_WORK, new OkHttpClient.Builder().build(), false));
        } catch (Exception e) {
            System.out.printf("error");
        }
    }


    public static void main(String[] args) throws Exception {

        pks.forEach((address, credentials) -> {
            executor.submit(() -> {

                int i = 2;
                while (true && i-- >= 0) {
                    try {
//                        System.out.println("当前地址：" + address);
//                        BigInteger balance = getBalance(address);
//                        System.out.println("当前C余额：" + balance);
//                        BigInteger nonce = getNonce(address);
//                        System.out.println("当前nonce：" + nonce);

                        BigInteger gasPrice = web3j.ethGasPrice().send().getGasPrice().multiply(BigInteger.valueOf(1L));
                        System.out.println("gasPrice:" + gasPrice);
                        BigInteger gasLimit = BigInteger.valueOf(50000L);

                        // 设置交易的金额
                        BigDecimal amount = BigDecimal.ZERO; // Convert.toWei(new BigDecimal("0.1"), Convert.Unit.ETHER);

                        // 创建 RawTransactionManager
                        RawTransactionManager rawTransactionManager = new RawTransactionManager(web3j, credentials, CHAIN_ID, 60, 3000);

                        // 发送交易
                        Transfer transfer = new Transfer(web3j, rawTransactionManager);
                        TransactionReceipt tx = transfer.sendFunds(address, amount, Convert.Unit.WEI, gasPrice, gasLimit).send();
                        System.out.println("tx:" + tx.getTransactionHash());
                    } catch (Exception e) {
                        System.out.println("init address:" + address + " error:" + e.getMessage());
                        try {
                            Thread.sleep(1000L);
                        } catch (Throwable err) {

                        }
                    } finally {
                        //
                    }
                }
            });
//            System.out.println(executor.);
        });

    }

    private static BigInteger getNonce(String address) {
        try {
            EthGetTransactionCount ethGetTransactionCount = web3j.ethGetTransactionCount(address, org.web3j.protocol.core.DefaultBlockParameterName.LATEST).send();
            return ethGetTransactionCount.getTransactionCount();
        } catch (IOException e) {
            System.err.println("获取交易计数（nonce）失败：" + e.getMessage());
            return BigInteger.ZERO;
        }
    }

    private static BigInteger getBalance(String address) throws IOException {
        BigInteger bn = web3j.ethBlockNumber().send().getBlockNumber();
        return web3j.ethGetBalance(address, DefaultBlockParameter.valueOf(bn)).send().getBalance();
    }

}