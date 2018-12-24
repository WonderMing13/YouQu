package org.wonderming.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wonderming.exception.BaseException;
import org.wonderming.exception.ExceptionUtils;

import javax.servlet.http.HttpServletRequest;
import java.net.*;
import java.util.Enumeration;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 王德明
 * @Date: 2018/12/24
 * @Time: 10:02
 * @Project: youqu
 * @Package: org.wonderming.utils
 */
public class IpUtils {

    private static final Logger IP_LOGGER = LoggerFactory.getLogger(IpUtils.class);
    private static final String UNKNOWN = "unknown";
    private static final String CHECK_COMMA = ",";
    private static final String CHECK_COLON = ":";
    /**
     *  ipv4的正则表达式
     */
    private static final Pattern IPV4_PATTERN = Pattern.compile("^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\." +"(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\." +"(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\." +"(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$");

    /**
     *  获取本机Ip
     * @return
     */
    public static String getLocalIp() {
        String localIP = "127.0.0.1";
        try {
            Enumeration netInterfaces = NetworkInterface.getNetworkInterfaces();
            while (netInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = (NetworkInterface) netInterfaces.nextElement();
                InetAddress inetAddress = networkInterface.getInetAddresses().nextElement();
                if (!inetAddress.isLoopbackAddress() && !inetAddress.getHostAddress().contains(CHECK_COLON)) {
                    if (inetAddress instanceof Inet4Address) {
                        localIP = inetAddress.getHostAddress();
                        break;
                    }
                }
            }
        } catch (Exception e) {
            try {
                localIP = InetAddress.getLocalHost().getHostAddress();
            } catch (UnknownHostException e1) {
                IP_LOGGER.error("转换异常",ExceptionUtils.getStackTrace(e1));
                throw new BaseException(e1);
            }
        }
        return localIP;
    }

    /**
     *  获取客户机IP,获取多级反向代理的ip
     * @return
     */
    public static String getClientIp(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("http_client_ip");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        // 如果是多级代理，那么取第一个ip为客户ip
        if (ip != null && ip.contains(CHECK_COMMA)) {
            ip = ip.substring(ip.lastIndexOf(",") + 1, ip.length()).trim();
        }
        return ip;
    }

}
