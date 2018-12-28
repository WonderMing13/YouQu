package org.wonderming.utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.Map;


/**
 * Created with IntelliJ IDEA.
 *
 * @author: 王德明
 * @Date: 2018/12/17
 * @Time: 15:12
 * @Project: youqu
 * @Package: org.wonderming.utils
 */
public class HttpClientUtils {
    /**
     * 设置字符编码
     */
    private static final String CHARSET_CODING = "UTF-8";
    /**
     * 默认超时时间6分钟
     */
    private static int TIMEOUT_DEAFAULT = 60000;
    /**
     *  HTTP内容类型
     */
    private static final String CONTENT_TYPE_TEXT_HTML = "text/html";
    /**
     *  HTTP内容类型,表单提交
     */
    private static final String CONTENT_TYPE_FORM_URL = "application/x-www-form-urlencoded";
    /**
     *  HTTP内容类型,json提交
     */
    private static final String CONTENT_TYPE_JSON_URL = "application/json;charset=utf-8";
    /**
     * 最大连接数
     */
    private static int MAX_TOTAL = 200;
    /**
     * 最大路由
     */
    private static int DEFAULT_MAX_PERROUTE = 2;
    /**
     *  连接池管理器
     */
    private static PoolingHttpClientConnectionManager poolingHttpClientConnectionManager;
    /**
     *  请求配置
     */
    private static RequestConfig requestConfig;
    /**
     *  logback日志
     */
    private static final Logger HTTPCLIENT_LOGGER = LoggerFactory.getLogger(HttpClientUtils.class);
    /**
     *  http状态成功码
     */
    private static final int HTTP_SUCCESS_STATUS = 200;
    /**
     *  最大http状态成功码
     */
    private static final int HTTP_MAX_SUCCESS_STATUS = 299;


    static {
        try {
            //忽略服务端的SSL证书
            SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(SSLContexts.custom().loadTrustMaterial((chain, authType) -> true).build());
            //同时支持HTTP和HTTPS请求
            Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create().register(
                    "http", PlainConnectionSocketFactory.getSocketFactory()).register(
                    "https", sslConnectionSocketFactory).build();
            // 初始化连接管理器
            poolingHttpClientConnectionManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
            //最大连接数
            poolingHttpClientConnectionManager.setMaxTotal(MAX_TOTAL);
            //最大路由
            poolingHttpClientConnectionManager.setDefaultMaxPerRoute(DEFAULT_MAX_PERROUTE);
            //设置请求参数requestConfig
            requestConfig = RequestConfig.custom().setSocketTimeout(TIMEOUT_DEAFAULT).setConnectTimeout(TIMEOUT_DEAFAULT)
                    .setConnectionRequestTimeout(TIMEOUT_DEAFAULT).build();
        } catch (NoSuchAlgorithmException | KeyManagementException | KeyStoreException e) {
            HTTPCLIENT_LOGGER.error("初始设置Http异常堆栈:",e);
        }
    }

    /**
     * 获取默认的HttpClient对象
     * @return
     */
    public CloseableHttpClient getDefaultClient() {
        return HttpClients.createDefault();
    }

    /**
     * 获取设置的HttpClient对象
     * @return
     */
    public static CloseableHttpClient getHttpClient() {
        CloseableHttpClient httpClient = HttpClients.custom()
                .setConnectionManager(poolingHttpClientConnectionManager)
                .setDefaultRequestConfig(requestConfig)
                .setRetryHandler(new DefaultHttpRequestRetryHandler(0,false))
                .build();
        return httpClient;
    }

    /**
     * 发送HttpPost请求基础方法
     * @param httpPost
     * @return
     */
    public static String sendHttpPost(HttpPost httpPost) {
        CloseableHttpResponse response = null;
        String responseContent = null;
        try {
            //HttpPost配置请求参数
            httpPost.setConfig(requestConfig);
            //执行请求
            response = getHttpClient().execute(httpPost);
            //得到响应实例
            HttpEntity httpEntity = response.getEntity();
            //判断响应状态
            if (response.getStatusLine().getStatusCode() > HTTP_MAX_SUCCESS_STATUS || response.getStatusLine().getStatusCode() < HTTP_SUCCESS_STATUS) {
                HTTPCLIENT_LOGGER.error("HttpPost请求失败！状态码：" + response.getStatusLine().getStatusCode());
            }
            //成功状态
            if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
                responseContent = EntityUtils.toString(httpEntity,CHARSET_CODING);
                //关闭流
                EntityUtils.consume(httpEntity);
            }
        } catch (IOException e) {
            HTTPCLIENT_LOGGER.error("Http基础方法异常堆栈:",e);
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    HTTPCLIENT_LOGGER.error("Http关闭线程池异常堆栈:",e);
                }
            }
        }
        return responseContent;
    }

    /**
     *  发送HttpPost请求
     * @param url
     * @return
     */
    public static String sendHttpPost(String url) {
        HttpPost httpPost = new HttpPost(url);
        return sendHttpPost(httpPost);
    }

    /**
     * 发送 post请求
     *
     * @param maps
     *            参数
     */
    public static String sendHttpPost(String httpUrl, Map<String, String> maps) {
        String param = convertStringParamter(maps);
        return sendHttpPost(httpUrl, param);
    }

    /**
     * 设置请求体
     * @param httpPost
     * @param paramsJson
     * @param contentType
     */
    public static void modifyEntity(HttpPost httpPost,String paramsJson,String contentType) {
        if (paramsJson != null && paramsJson.trim().length() > 0) {
            StringEntity stringEntity = new StringEntity(paramsJson, "UTF-8");
            stringEntity.setContentType(contentType);
            httpPost.setEntity(stringEntity);
        }
    }


    /**
     * 发送 post请求
     *
     * @param httpUrl
     *            地址
     * @param params
     *            参数(格式:key1=value1&key2=value2)
     *
     */
    public static String sendHttpPost(String httpUrl, String params) {
        HttpPost httpPost = new HttpPost(httpUrl);
        modifyEntity(httpPost,params,CONTENT_TYPE_FORM_URL);
        return sendHttpPost(httpPost);
    }

    /**
     * 发送 post请求 发送json数据
     *
     * @param httpUrl
     *            地址
     * @param paramsJson
     *            参数(格式 json)
     *
     */
    public static String sendHttpPostJson(String httpUrl, String paramsJson) {
        HttpPost httpPost = new HttpPost(httpUrl);
        modifyEntity(httpPost,paramsJson,CONTENT_TYPE_JSON_URL);
        return sendHttpPost(httpPost);
    }

    /**
     * 发送 post请求 发送xml数据
     *
     * @param httpUrl   地址
     * @param paramsXml  参数(格式 Xml)
     *
     */
    public static String sendHttpPostXml(String httpUrl, String paramsXml) {
        HttpPost httpPost = new HttpPost(httpUrl);
        modifyEntity(httpPost,paramsXml,CONTENT_TYPE_TEXT_HTML);
        return sendHttpPost(httpPost);
    }

    /**
     * 将map集合的键值对转化成：key1=value1&key2=value2 的形式
     *
     * @param parameterMap
     *            需要转化的键值对集合
     * @return 字符串
     */
    public static String convertStringParamter(Map parameterMap) {
        StringBuffer parameterBuffer = new StringBuffer();
        if (parameterMap != null) {
            Iterator iterator = parameterMap.keySet().iterator();
            String key = null;
            String value = null;
            while (iterator.hasNext()) {
                key = (String) iterator.next();
                if (parameterMap.get(key) != null) {
                    value = (String) parameterMap.get(key);
                } else {
                    value = "";
                }
                parameterBuffer.append(key).append("=").append(value);
                if (iterator.hasNext()) {
                    parameterBuffer.append("&");
                }
            }
        }
        return parameterBuffer.toString();
    }





}
