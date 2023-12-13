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

import java.io.*;
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
            File file = new File("src/main/resources/arbitrum.properties");
            InputStream in = new FileInputStream(file);
            Properties props = new Properties();
            InputStreamReader inputStreamReader = new InputStreamReader(in, "UTF-8");
            props.load(inputStreamReader);

            BSC_NET = props.getProperty("NET_WORK");
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
        Credentials credentials = Credentials.create("b9a238f0abdf08228bed2f997cd26c4635bd57ae5f111dd7f97a3d2fb6c71e18");
        BigInteger nonce = getNonce(credentials.getAddress());
        System.out.println("当前地址：" + credentials.getAddress());
//        erc20RPC.approve(credentials, "0x1194c91d47fc1b65be18db38380b5344682b67db", "0x5eb765A65Af9fDDfa56F9aD80BbcA375FE7A1d30", new BigInteger("2").pow(255), CHAIN_ID, nonce);
//        erc20RPC.approve(credentials, "0x1194C91d47Fc1b65bE18db38380B5344682b67db", "0x68b3465833fb72A70ecDF485E0e4C7bD8665Fc45", new BigInteger("2").pow(255), CHAIN_ID, nonce);
//        erc20RPC.approve(credentials, "0x55d398326f99059fF775485246999027B3197955", "0x7014daf2Fd59C4f2183Fb48Fb969D444e83fe1Ec", new BigInteger("2").pow(255), 56L, nonce);
//        erc20RPC.approve(credentials, "0xc2132D05D31c914a87C6611C10748AEb04B58e8F", "0x7014daf2Fd59C4f2183Fb48Fb969D444e83fe1Ec", new BigInteger("2").pow(255), 137L, nonce);
        erc20RPC.approve(credentials, "0xFd086bC7CD5C481DCC9C85ebE478A1C0b69FCbb9", "0x7014daf2Fd59C4f2183Fb48Fb969D444e83fe1Ec", new BigInteger("2").pow(255), 42161L, nonce);

    }


    public void approve(Credentials credentials, String tokenAddress, String spender, BigInteger amount, Long chainId, BigInteger nonce) throws IOException {
        Function func = new Function("approve", Arrays.asList(new Address(spender), new Uint256(amount)), Arrays.asList());
        String signData = SignUtil.signFunctionCall(credentials, tokenAddress, func, nonce, gasPrice, gasLimit, chainId);
        String txIdBefore = Hash.sha3(signData);
        System.out.println("txIdBefore= " + txIdBefore);
        EthSendTransaction tr = broadcast(signData);
        String txHash = tr.getTransactionHash();
        System.out.println("交易已广播，交易哈希（txHash）： " + txHash);

    }

    private EthSendTransaction broadcast(String signData) throws IOException {
        EthSendTransaction ethSendTransaction = web3j.ethSendRawTransaction(signData).send();
        return ethSendTransaction;
    }
}
