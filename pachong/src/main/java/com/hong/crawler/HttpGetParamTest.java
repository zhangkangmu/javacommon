package com.hong.crawler;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by zhangyuhong
 * Date:2020/3/23
 *
 * 2.get请求携带参数
 */
public class HttpGetParamTest {
    public static void main(String[] args) {
        CloseableHttpClient httpClient =null;
         CloseableHttpResponse response = null;
        try {
            //1.打开浏览器,创建httpclient对象
            httpClient = HttpClients.createDefault();
            URIBuilder uriBuilder = new URIBuilder("http://yun.itheima.com/search");
            //多个参数请求
            uriBuilder.setParameter("keys","java").setParameter("","");
            //2.输入网址,发起get请求创建httpget对象
//        HttpGet httpGet = new HttpGet("https://www.baidu.com");
            HttpGet httpGet = new HttpGet(uriBuilder.build());
            //3.按回车,发起请求,返回响应,使用httpClient对象发起请求
            response = httpClient.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == 200) {
                //4.解析响应,获取数据
                HttpEntity httpEntity = response.getEntity();
                //返回的是一个完整的http页面
                String string = EntityUtils.toString(httpEntity, "utf-8");
                System.out.println(string);
            }
        } catch (Exception e) {
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
