package com.scumm.web3.erc20;

import org.apache.commons.lang3.StringUtils;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.RawTransaction;
import org.web3j.crypto.TransactionEncoder;
import org.web3j.utils.Convert;
import org.web3j.utils.Numeric;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;

/**
 * ETH/BSC 合约调用签名类
 */
public class SignUtil {


    //ETH/BSV 主网币transfer签名
    public static String signEthTransfer(Credentials credentials, BigInteger nonce, BigInteger gasPrice, BigInteger gasLimit, BigDecimal amount, Long chainId, String toAddress) {
        BigInteger amountWei = Convert.toWei(amount, Convert.Unit.ETHER).toBigInteger();
        //签名交易
        RawTransaction rawTransaction = RawTransaction.createTransaction(nonce, gasPrice, gasLimit, toAddress, amountWei, StringUtils.EMPTY);
        byte[] signMessage = TransactionEncoder.signMessage(rawTransaction, chainId, credentials);
        return Numeric.toHexString(signMessage);
    }


    //ETH/BSC 合约币transfer签名
    public static String signTokenTransfer(Credentials credentials, String tokenAddress, int decimal, BigInteger nonce, BigInteger gasPrice, BigInteger gasLimit, BigDecimal amount, Long chainId, String toAddress) {
        //合约单独计算精度
        BigInteger tokenAmount = amount.multiply(BigDecimal.TEN.pow(decimal)).toBigInteger();
        //封装转账交易
        Function function = new Function("transfer", Arrays.asList(new Address(toAddress), new Uint256(tokenAmount)), Collections.emptyList());
        String encodedFunctionCall = FunctionEncoder.encode(function);
        //签名交易
        RawTransaction rawTransaction = RawTransaction.createTransaction(nonce, gasPrice, gasLimit, tokenAddress, encodedFunctionCall);

        byte[] signMessage = TransactionEncoder.signMessage(rawTransaction, chainId, credentials);
        return Numeric.toHexString(signMessage);
    }

    //ETH/BSC 合约指定Function签名
    public static String signFunctionCall(Credentials credentials, String contractAddress, Function function, BigInteger nonce, BigInteger gasPrice, BigInteger gasLimit, Long chainId) {
        //封装转账交易
        String encodedFunctionCall = FunctionEncoder.encode(function);
        //签名交易
        RawTransaction rawTransaction = RawTransaction.createTransaction(nonce, gasPrice, gasLimit, contractAddress, encodedFunctionCall);

        byte[] signMessage = TransactionEncoder.signMessage(rawTransaction, chainId, credentials);
        return Numeric.toHexString(signMessage);
    }


}
