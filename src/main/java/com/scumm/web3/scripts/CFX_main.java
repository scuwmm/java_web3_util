package com.scumm.web3.scripts;

import com.scumm.web3.erc20.ERC20RPC;
import com.scumm.web3.erc20.SignUtil;
import okhttp3.OkHttpClient;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.RawTransaction;
import org.web3j.crypto.TransactionEncoder;
import org.web3j.model.ERC20Token;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.methods.response.EthGasPrice;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import org.web3j.protocol.core.methods.response.EthSendTransaction;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.Transfer;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.utils.Convert;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class CFX_main {

    private static Web3j web3j;
    private static String NET_WORK;

    public static final String TO_ADDRESS = "0xc6e865c213c89ca42a622c5572d19f00d84d7a16";
    private static final String PRIVATE_KEY = "";

    static {
        try {
            File file = new File("src/main/resources/cfx.properties");
            InputStream in = new FileInputStream(file);
            Properties props = new Properties();
            InputStreamReader inputStreamReader = new InputStreamReader(in, "UTF-8");
            props.load(inputStreamReader);

            NET_WORK = "https://evm.confluxrpc.com";
            web3j = Web3j.build(new org.web3j.protocol.http.HttpService(NET_WORK, new OkHttpClient.Builder().build(), false));

        } catch (Exception e) {
            System.out.printf("error");
        }
    }


    public static void main(String[] args) throws Exception {

        Credentials credentials = Credentials.create(PRIVATE_KEY);

        System.out.println("当前地址：" + credentials.getAddress());

//        BigInteger balance = getBalance(credentials.getAddress());
//        System.out.println("当前CFX余额：" + balance);

        int i = Constants.ONCE;
        while (i-- > 0) {
            try {
//                System.out.println("i: " + i);
//                BigInteger nonce = getNonce(credentials.getAddress());
//                System.out.println("当前nonce：" + nonce);

//                ERC20Token token = ERC20Token.load("0xc6e865c213c89ca42a622c5572d19f00d84d7a16", web3j, credentials, new DefaultGasProvider());
//                BigInteger balance2 = token.balanceOf(credentials.getAddress()).send();
//                System.out.println("铭文前 balance: " + balance2);

                // 设置 gas price
//        BigInteger gasPrice = Convert.toWei("20", Convert.Unit.GWEI).toBigInteger();
                BigInteger gasPrice = web3j.ethGasPrice().send().getGasPrice();
                System.out.println("gasPrice:" + gasPrice);

                // 设置交易的金额
//                BigDecimal amount = new BigDecimal("0");
//                BigInteger value = Convert.toWei(amount, Convert.Unit.ETHER).toBigInteger();


                // 创建 RawTransactionManager
                RawTransactionManager rawTransactionManager = new RawTransactionManager(
                        web3j, credentials, 1030L, 600, 1000);

                Transfer transfer = new Transfer(web3j, rawTransactionManager);
                // 发送交易
                TransactionReceipt tx = transfer.sendFunds(TO_ADDRESS, BigDecimal.ZERO, Convert.Unit.WEI, gasPrice, Constants.GAS_LIMIT).send();
                System.out.println("tx:" + tx.getTransactionHash());
            } catch (Exception e) {
                System.out.printf("error");
                Thread.sleep(2000L);
            }

        }

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

    private static EthSendTransaction broadcast(String signData) throws IOException {
        EthSendTransaction ethSendTransaction = web3j.ethSendRawTransaction(signData).send();
        return ethSendTransaction;
    }
}