package com.hong.crawler;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Map;

/**
 * Created by zhangyuhong
 * Date:2020/3/23
 * 1.入门案例--get请求
 */
public class CrawlerFirst {

    public static void main(String[] args) {
        //1.打开浏览器,创建httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //2.输入网址,发起get请求创建httpget对象
        HttpGet httpGet = new HttpGet("https://www.baidu.com");
        //3.按回车,发起请求,返回响应,使用httpClient对象发起请求
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == 200) {
                //4.解析响应,获取数据
                HttpEntity httpEntity = response.getEntity();
                //返回的是一个完整的http页面
                String string = EntityUtils.toString(httpEntity, "utf-8");
                System.out.println(string);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //5.关闭response,httpclient
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
