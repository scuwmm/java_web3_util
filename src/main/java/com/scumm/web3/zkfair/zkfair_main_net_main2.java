package com.scumm.web3.zkfair;

import com.scumm.web3.scripts.Constants;
import okhttp3.OkHttpClient;
import org.apache.commons.collections4.properties.PropertiesFactory;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.RawTransaction;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import org.web3j.protocol.core.methods.response.EthSendTransaction;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.FastRawTransactionManager;
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

public class zkfair_main_net_main2 {

    private static Web3j web3j;
    private static String NET_WORK;
    private static Long CHAIN_ID;
    private static ExecutorService executor = Executors.newFixedThreadPool(16);

    private static Map<String, Credentials> pks;

    static {
        try {
            Properties props = PropertiesFactory.INSTANCE.load("src/main/resources/zkfair2.properties");
            NET_WORK = props.getProperty("NET_WORK");
            CHAIN_ID = Long.parseLong(props.getProperty("CHAIN_ID"));
//            String PRIVATE_KEYS =props.getProperty("PRIVATE_KEYS");
            web3j = Web3j.build(new HttpService(NET_WORK, new OkHttpClient.Builder().build(), false));

            pks = Arrays.asList(props.getProperty("PRIVATE_KEYS").split(","))
                    .stream().map(pk -> {
                        Credentials c = Credentials.create(pk);
//                        BigDecimal balance = Convert.fromWei(String.valueOf(getBalance(c.getAddress())), Convert.Unit.ETHER);
//                        System.out.println("address= " + c.getAddress() + " pk=" + pk + " balance=" + balance);
                        return c;
                    })
                    .collect(Collectors.toMap(pk -> pk.getAddress(), pk -> pk));
            System.out.println("Init end.");

        } catch (Exception e) {
            System.out.printf("error");
        }
    }


    public static void main(String[] args) throws Exception {

        pks.forEach((address, credentials) -> {
            executor.submit(() -> {

                int i = 10000;
                while (true && i-- >= 0) {
                    try {
//                        System.out.println("当前地址：" + address);
//                        BigInteger balance = getBalance(address);
//                        System.out.println("当前C余额：" + balance);
//                        BigInteger nonce = getNonce(address);
//                        System.out.println("当前nonce：" + nonce);

                        //100000 , 10000
//                        BigInteger gasPrice = web3j.ethGasPrice().send().getGasPrice().multiply(BigInteger.valueOf(1L));
                        BigInteger gasPrice = BigInteger.valueOf(20000).multiply(Constants.GWEI);
                        //5000000000
                        BigInteger gasLimit = BigInteger.valueOf(200000L);
                        System.out.println("gasPrice:" + Convert.fromWei(gasPrice.toString(), Convert.Unit.ETHER) + ", max gas:" + Convert.fromWei(gasPrice.multiply(gasLimit).toString(), Convert.Unit.ETHER));

                        // 设置交易的金额
                        BigDecimal amount = Convert.toWei(BigDecimal.valueOf(0.0001), Convert.Unit.ETHER); // Convert.toWei(new BigDecimal("0.1"), Convert.Unit.ETHER);

                        String extraData = "0x68656c6c6f20776f726c6468656c6c6f20776f726c6468656c6c6f20776f726c6468656c6c6f20776f726c6468656c6c6f20776f726c6468656c6c6f20776f726c6468656c6c6f20776f726c6468656c6c6f20776f726c6468656c6c6f20776f726c6468656c6c6f20776f726c6468656c6c6f20776f726c6468656c6c6f20776f726c6468656c6c6f20776f726c6468656c6c6f20776f726c6468656c6c6f20776f726c6468656c6c6f20776f726c6468656c6c6f20776f726c6468656c6c6f20776f726c6468656c6c6f20776f726c6468656c6c6f20776f726c6468656c6c6f20776f726c6468656c6c6f20776f726c6468656c6c6f20776f726c6468656c6c6f20776f726c6468656c6c6f20776f726c6468656c6c6f20776f726c6468656c6c6f20776f726c6468656c6c6f20776f726c64"; // 以十六进制表示的字符串，可以是任何你想要附加的数据

                        // 使用 FastRawTransactionManager 创建原始交易管理器
                        FastRawTransactionManager rawTransactionManager = new FastRawTransactionManager(web3j, credentials);

                        // 构建原始交易
                        RawTransaction rawTransaction = RawTransaction.createTransaction(
                                    null, gasPrice, gasLimit, "0x3029f75c9eca32C9D68B64d370B479c41A165F61", amount.toBigIntegerExact(), extraData);

                        // 使用原始交易管理器发送交易
                        EthSendTransaction ethSendTransaction = rawTransactionManager.signAndSend(rawTransaction);
                        String transactionHash = ethSendTransaction.getTransactionHash();

//                        BigInteger nonce = getNonce(address);
//                        // 构建原始交易
//                        RawTransaction rawTransaction = RawTransaction.createTransaction(
//                                nonce, gasPrice, gasLimit, "0x3029f75c9eca32C9D68B64d370B479c41A165F61", amount.toBigInteger(), extraData);
//
//                        // 使用 RawTransactionManager 创建原始交易管理器
//                        RawTransactionManager rawTransactionManager = new RawTransactionManager(web3j, credentials);
//
//                        // 将原始交易发送到网络
//                        EthSendTransaction ethSendTransaction = rawTransactionManager.signAndSend(rawTransaction);
//                        String transactionHash = ethSendTransaction.getTransactionHash();
                        System.out.println("Transaction Hash: " + transactionHash);


                    } catch (Exception e) {
                        System.out.println("address:" + address + " send tx error:" + e.getMessage());
                        try {
                            Thread.sleep(2000L);
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

    private static BigInteger getBalance(String address) {
        try {
            BigInteger bn = web3j.ethBlockNumber().send().getBlockNumber();
            return web3j.ethGetBalance(address, DefaultBlockParameter.valueOf(bn)).send().getBalance();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

    }

}