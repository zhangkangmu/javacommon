package com.hong.crawler;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by zhangyuhong
 * Date:2020/3/23
 *
 * 3.post请求携带参数
 */
public class HttpPostParamTest {
    public static void main(String[] args) {
        CloseableHttpClient httpClient =null;
         CloseableHttpResponse response = null;
        try {
            //1.打开浏览器,创建httpclient对象
            httpClient = HttpClients.createDefault();
            //2.创建post请求
            HttpPost httpPost = new HttpPost("http://yun.itheima.com/search");
            //2.1声明list集合,封装表单中的参数
            ArrayList<NameValuePair> params = new ArrayList<>();
            //2.2增加参数
            params.add(new BasicNameValuePair("keys","java"));
            //2.3创建表单的entity对象,第一个参数就是封装 好的表单数据,第二个是编码集
            UrlEncodedFormEntity encodedFormEntity = new UrlEncodedFormEntity(params, "utf8");
            //2.4设置表单的entity对象到post请求中
            httpPost.setEntity(encodedFormEntity);


            //3.按回车,发起请求,返回响应,使用httpClient对象发起请求
            response = httpClient.execute(httpPost);
            if (response.getStatusLine().getStatusCode() == 200) {
                //4.解析响应,获取数据
                HttpEntity httpEntity = response.getEntity();
                //返回的是一个完整的http页面
                String string = EntityUtils.toString(httpEntity, "utf-8");
                System.out.println("请求到的表单数据:"+string.length());
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
