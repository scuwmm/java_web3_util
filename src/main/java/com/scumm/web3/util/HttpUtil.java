package com.scumm.web3.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import java.util.concurrent.TimeUnit;

public class HttpUtil {

    public static String httpGet(String url) {
        System.out.println("httpGet url: " + url);
        HttpGet httpGet = new HttpGet(url);
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            httpGet.setConfig(RequestConfig.custom()
                    .setConnectionRequestTimeout(10000L, TimeUnit.MILLISECONDS)
                    .build());
            try (CloseableHttpResponse response = httpclient.execute(httpGet)) {
                // 获取响应代码
                int statusCode = response.getCode();
                if (200 == statusCode) {
                    // 读取响应内容
                    return EntityUtils.toString(response.getEntity());
                } else {
                    System.out.println("http get " + url + " failed " + response.getCode());
                    return null;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
