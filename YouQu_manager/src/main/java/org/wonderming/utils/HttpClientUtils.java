package org.wonderming.utils;


import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.ssl.TrustStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;


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

    private static final Logger HTTPCLIENT_LOGGER = LoggerFactory.getLogger(HttpClientUtils.class);

    static {
        try {
            SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(SSLContexts.custom().loadTrustMaterial((chain, authType) -> true).build());

            Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory> create().register(
                    "http", PlainConnectionSocketFactory.getSocketFactory()).register(
                    "https", sslConnectionSocketFactory).build();

            PoolingHttpClientConnectionManager poolingHttpClientConnectionManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
            poolingHttpClientConnectionManager.setMaxTotal(200);
            poolingHttpClientConnectionManager.setDefaultMaxPerRoute(2);

        } catch (NoSuchAlgorithmException | KeyManagementException | KeyStoreException e) {
            e.printStackTrace();
        }


    }

    /**
     * 创建HttpClient对象
     * @return
     */
    public CloseableHttpClient getDefaultClient() {
        return HttpClients.createDefault();
    }



}
