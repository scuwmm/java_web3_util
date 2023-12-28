package com.scumm.web3.scripts;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.scumm.web3.service.Function;
import com.scumm.web3.util.HttpUtil;
import okhttp3.OkHttpClient;
import org.apache.commons.cli.*;
import org.apache.commons.collections4.properties.PropertiesFactory;
import org.apache.commons.lang3.StringUtils;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.Keys;
import org.web3j.crypto.WalletUtils;
import org.web3j.model.CFXSTestToMain;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.gas.StaticGasProvider;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import static com.scumm.web3.util.Constants.PARENT_RESOURCE_PATH;

public class CFXs_TestToMain {

    private static Properties props = new Properties();
//    private static Web3jUtil web3jUtil;

    private static Web3j web3j;
    private static Long chainId;
    private static Credentials credentials;
    private static String contractAddress;

    private static String to;

    private static void init(String[] args) {
        CommandLineParser parser = new DefaultParser();

        Options options = new Options();
        options.addOption("s", "resource", true, "resource file name");
        options.addOption("r", "rpc", true, "rpc node");
        options.addOption("c", "chainId", true, "chain id");
        options.addOption("p", "privateKey", true, "private key");
        options.addOption("a", "contractAddress", true, "ERC20 contract address");
        options.addOption("t", "toAddress", true, "transfer to address");
        options.addOption("h", "help", false, "Print help");

        try {
            CommandLine cmd = parser.parse(options, args);
            if (cmd.hasOption("h")) {
                HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp("java -jar your.jar [options]", options);
                System.exit(0);
            }
            try {
                if (cmd.hasOption("s")) {
                    String resourceFileName = cmd.getOptionValue("s");
                    props = PropertiesFactory.INSTANCE.load(PARENT_RESOURCE_PATH + resourceFileName + ".properties");
                }
            } catch (Exception e) {
                System.out.println("no resource file.");
            }

            String rpc = cmd.getOptionValue("r", props.getProperty("rpc"));


            chainId = Long.parseLong(cmd.getOptionValue("c", props.getProperty("chainId")));
            String pk = cmd.getOptionValue("p", props.getProperty("privateKey"));
            if (StringUtils.isEmpty(rpc) || StringUtils.isEmpty(pk)) {
                System.out.println("rpc or chainId is empty, process will exit");
                System.exit(0);
            }

            credentials = Credentials.create(pk);
            web3j = Web3j.build(new HttpService(rpc, new OkHttpClient.Builder().build(), false));
            //            web3jUtil = Web3jUtil.newWeb3j(rpc);
            contractAddress = cmd.getOptionValue("a");
            to = cmd.getOptionValue("t", credentials.getAddress());

            System.out.println("rpc: " + rpc);
            System.out.println("chainId: " + chainId);
            System.out.println("pk: " + pk.substring(0, 20) + "***");
            System.out.println("contractAddress: " + contractAddress);
            System.out.println("from: " + credentials.getAddress());
            System.out.println("to: " + to);

        } catch (Exception e) {
            System.out.println("Error parsing command line: " + e.getMessage());
            System.exit(0);
        }
    }

    public static void main(String[] args) throws IOException {
        init(args);

        run();
    }

    private static void run() {
        ((Function<Object, String>) o -> {
            try {
                BigInteger gasPrice = web3j.ethGasPrice().send().getGasPrice();
                RawTransactionManager rwm = new RawTransactionManager(web3j, credentials, chainId, 60, 3000L);
                CFXSTestToMain testToMain = CFXSTestToMain.load(contractAddress, web3j, rwm, new StaticGasProvider(gasPrice, BigInteger.valueOf(10000000L)));
                String url = new StringBuilder()
                        .append("https://www.conins.io/getCfxsList?owner=")
                        .append(Keys.toChecksumAddress(credentials.getAddress()))
                        .append("&startIndex=0&size=32").toString();
                String res = HttpUtil.httpGet(url);
                if (StringUtils.isNotEmpty(res)) {
                    JSONObject jo = JSON.parseObject(res);
                    System.out.println("old balance: " + jo.getInteger("count"));
                    JSONArray array = jo.getJSONArray("rows");
                    List<BigInteger> ids = Arrays.stream(array.toArray()).map(obj -> {
                        JSONObject j = (JSONObject) obj;
                        String id = j.getString("id");
                        return new BigInteger(id);
                    }).collect(Collectors.toList());

                    if (ids.size() > 0) {
                        String tx = testToMain.ExTestToMain(ids).send().getTransactionHash();
                        System.out.println("send tx: " + tx);
                    }
                } else {
                    System.out.println("res is empty");
                }

                return null;
            } catch (Exception e) {
                System.out.println("execute error: " + e.getMessage());
                System.exit(0);
            }
            return null;

        }).run("");

    }

}

