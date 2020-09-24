package com.test.utils;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Arrays;

public class HttpUtils {
    /**
     * 发送一个get请求
     * @param url       携带参数的url
     *                  例如：http://api.lemonban.com/futureloan/loans?pageIndex=1&pageSize=1
     *                  例如：http://api.lemonban.com/futureloan/member/${member_id}/info
     * @throws Exception
     */
    public static void get(String url) throws Exception {
        //1、创建请求
        HttpGet get = new HttpGet(url);
        //2、添加请求头
        get.setHeader("X-Lemonban-Media-Type","lemonban.v1");
        //3、创建客户端
        HttpClient client = HttpClients.createDefault();
        //4、发送请求，获取响应对象
        HttpResponse response = client.execute(get);
        //5、格式化响应对象 response = 响应状态码 + 响应头 + 响应体
        printResponse(response);
    }

    public static void formGet(String url,String params) throws Exception {
        //1、创建请求
        HttpGet get = new HttpGet(url + "?" + params);
        //2、添加请求头
        get.setHeader("X-Lemonban-Media-Type","lemonban.v1");
        //3、创建客户端
        HttpClient client = HttpClients.createDefault();
        //4、发送请求，获取响应对象
        HttpResponse response = client.execute(get);
        //5、格式化响应对象 response = 响应状态码 + 响应头 + 响应体
        printResponse(response);
    }

    /**
     * 发送一个post请求
     * @param url           接口地址
     * @param params        接口参数
     * @throws Exception
     */
    public static void jsonPost(String url,String params) throws Exception {
        //1、创建请求
        HttpPost post = new HttpPost(url);
        //2、添加请求头
        post.setHeader("X-Lemonban-Media-Type","lemonban.v1");
        post.setHeader("Content-Type","application/json");
        //3、添加请求体（参数）
        StringEntity body = new StringEntity(params,"utf-8");
        post.setEntity(body);
        //4、创建客户端
        HttpClient client = HttpClients.createDefault();
        //5、发送请求，获取响应对象
        HttpResponse response = client.execute(post);
        //6、格式化响应对象 response = 响应状态码 + 响应头 + 响应体
        printResponse(response);
    }

    public static void formPost(String url,String params) throws Exception {
        //1、创建请求
        HttpPost post = new HttpPost(url);
        //2、添加请求头
        post.setHeader("X-Lemonban-Media-Type","lemonban.v1");
        post.setHeader("Content-Type","application/x-www-form-urlencoded; charset=UTF-8");
        //3、添加请求体（参数）
        StringEntity body = new StringEntity(params,"utf-8");
        post.setEntity(body);
        //4、创建客户端
        HttpClient client = HttpClients.createDefault();
        //5、发送请求，获取响应对象
        HttpResponse response = client.execute(post);
        //6、格式化响应对象 response = 响应状态码 + 响应头 + 响应体
        printResponse(response);
    }


    /**
     * 打印响应
     * @param response          响应对象
     * @return
     * @throws IOException
     */
    public static String printResponse(HttpResponse response) throws IOException, IOException {
        //1响应状态码  链式编程
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println(statusCode);
        //2响应头
        Header[] allHeaders = response.getAllHeaders();
        System.out.println(Arrays.toString(allHeaders));
        //3响应体
        HttpEntity entity = response.getEntity();
        String body = EntityUtils.toString(entity);
        System.out.println(body);
        System.out.println("======================================================");
        return body;
    }
}


