package com.scumm.web3.erc20;

import okhttp3.OkHttpClient;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.Hash;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import org.web3j.protocol.core.methods.response.EthSendTransaction;
import org.web3j.utils.Numeric;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Properties;


public class ERC20RPC {

    //TODO 这里gasPrice和gasLimit根据实际情况进行调整
    private static BigInteger gasPrice = BigInteger.valueOf(500_000_000_000L);
    private static BigInteger gasLimit = BigInteger.valueOf(100_000L);

    private static String BSC_NET;

    private static Long CHAIN_ID = 5L; //TODO 改成可配置 goerli = 5
    private static Web3j web3j;

    static {
        try {
            File file = new File("src/main/resources/goerli.properties");
            InputStream in = new FileInputStream(file);
            Properties props = new Properties();
            InputStreamReader inputStreamReader = new InputStreamReader(in, "UTF-8");
            props.load(inputStreamReader);

            BSC_NET = props.getProperty("BSC_NET");
            web3j = Web3j.build(new org.web3j.protocol.http.HttpService(BSC_NET, new OkHttpClient.Builder().build(), false));

        } catch (Exception e) {
            System.out.printf("error");
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

    //FOR Test
    public static void main(String[] args) throws IOException {
        ERC20RPC erc20RPC = new ERC20RPC();
        Credentials credentials = Credentials.create("7f47e8366be88b5519012f0849f0527b695807cc8cd10bab4075f0ee83b250fb");
        BigInteger nonce = getNonce(credentials.getAddress());
        System.out.println(credentials.getAddress());
        erc20RPC.approve(credentials, "0x302BaE587Ab9E1667a2d2b0FD67730FEfDD1AB2d", "0x0c7033Fd16eB19FBA901DaA358C5c536FD34BE41", BigInteger.valueOf(1L), CHAIN_ID, nonce);

    }


    public void approve(Credentials credentials, String tokenAddress, String spender, BigInteger amount, Long chainId, BigInteger nonce) throws IOException {
        Function func = new Function("approve", Arrays.asList(new Address(spender), new Uint256(amount)), Arrays.asList());
        String signData = SignUtil.signFunctionCall(credentials, tokenAddress, func, nonce, gasPrice, gasLimit, chainId);
        String txIdBefore = Hash.sha3(signData);
        System.out.printf("txIdBefore=" + txIdBefore);
        EthSendTransaction tr = broadcast(signData);
        String txHash = tr.getTransactionHash();
        System.out.println("交易已广播，交易哈希（txHash）：" + txHash);

    }

    private EthSendTransaction broadcast(String signData) throws IOException {
        EthSendTransaction ethSendTransaction = web3j.ethSendRawTransaction(signData).send();
        return ethSendTransaction;
    }
}
