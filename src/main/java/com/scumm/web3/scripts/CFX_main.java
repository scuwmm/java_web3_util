package com.scumm.web3.scripts;

import com.scumm.web3.erc20.ERC20RPC;
import com.scumm.web3.erc20.SignUtil;
import okhttp3.OkHttpClient;
import org.web3j.crypto.Credentials;
import org.web3j.model.ERC20Token;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import org.web3j.protocol.core.methods.response.EthSendTransaction;
import org.web3j.tx.gas.DefaultGasProvider;

import java.io.*;
import java.math.BigInteger;
import java.util.Properties;

public class CFX_main {

    private static Web3j web3j;
    private static String NET_WORK;

    private static BigInteger gasPrice = BigInteger.valueOf(225000L);
    private static BigInteger gasLimit = BigInteger.valueOf(1000L);

    static {
        try {
            File file = new File("src/main/resources/cfx.properties");
            InputStream in = new FileInputStream(file);
            Properties props = new Properties();
            InputStreamReader inputStreamReader = new InputStreamReader(in, "UTF-8");
            props.load(inputStreamReader);

            NET_WORK = props.getProperty("NET_WORK");
            web3j = Web3j.build(new org.web3j.protocol.http.HttpService(NET_WORK, new OkHttpClient.Builder().build(), false));

        } catch (Exception e) {
            System.out.printf("error");
        }
    }


    public static final String TO_ADDRESS = "0xc6e865c213c89ca42a622c5572d19f00d84d7a16";

    public static void main(String[] args) throws Exception {

        Credentials credentials = Credentials.create("");

        System.out.println("当前地址：" + credentials.getAddress());

        BigInteger balance = getBalance(credentials.getAddress());
        System.out.println("当前CFX余额：" + balance);

        while (balance.compareTo(BigInteger.ZERO) > 0) {
            BigInteger nonce = getNonce(credentials.getAddress());
            System.out.println("当前Nonce：" + nonce);

//        String sign = SignUtil.signEthTransfer(credentials, nonce, gasPrice, gasLimit, BigDecimal.ZERO, 1030L, TO_ADDRESS);
//        EthSendTransaction tx = broadcast(sign);
//        System.out.println("交易tx：" + tx.getTransactionHash());

//        ERC20Token token = ERC20Token.load("0xc6e865c213c89ca42a622c5572d19f00d84d7a16", web3j, credentials, new DefaultGasProvider());
//        BigInteger balance2 = token.balanceOf(credentials.getAddress()).send();
//        System.out.println("铭文balance: " + balance2);
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
