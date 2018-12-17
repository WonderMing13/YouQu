package org.wonderming.password;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 王德明
 * @Date: 2018/12/17
 * @Time: 15:37
 * @Project: youqu
 * @Package: org.wonderming.password
 */
public class DesUtils {
    /**
     * key对象
     */
    private static SecretKey secretKey = null;
    /**
     *  私鈅加密对象Cipher
     */
    private static Cipher cipher = null;
    /**
     * 密钥
     */
    private final static String SECRET_KEY = "";
    private final static String keyFinall = SECRET_KEY.substring(0, 16) + SECRET_KEY.substring(0, 8);
    private static Logger DES_LOGGER = LoggerFactory.getLogger(DesUtils.class);

    static{
        try {
            //获得密钥
            secretKey = new SecretKeySpec(keyFinall.getBytes("ASCII"), "DESede");
            /*获得一个私鈅加密类Cipher，DESede是算法，ECB是加密模式，PKCS5Padding是填充方式*/
            cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
        } catch (Exception e) {
            DES_LOGGER.error(e.getMessage(), e);
        }
    }

    /**
     * 加密
     * @param message
     * @return
     */
    public static String desEncrypt(String message) {
        //DES加密字符串
        String result = "";
        //去掉换行符后的加密字符串
        String newResult = "";
        try {
            //设置工作模式为加密模式，给出密钥
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            //正式执行加密操作
            byte[] resultBytes = cipher.doFinal(message.getBytes("UTF-8"));
            BASE64Encoder enc = new BASE64Encoder();
            //进行BASE64编码
            result = enc.encode(resultBytes);
            //去掉加密串中的换行符
            //newResult = filter(result);
        } catch (Exception e) {
            DES_LOGGER.error(e.getMessage(), e);
        }
        return result;
    }

    /**
     * 解密
     * @param message
     * @return
     * @throws Exception
     */
    public static String desDecrypt(String message) throws Exception {
        String result = "";
        try {
            BASE64Decoder dec = new BASE64Decoder();
            //进行BASE64编码
            byte[] messageBytes = dec.decodeBuffer(message);
            //设置工作模式为解密模式，给出密钥
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            //正式执行解密操作
            byte[] resultBytes = cipher.doFinal(messageBytes);
            result = new String(resultBytes,"UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 去掉加密字符串换行符
     * @param str
     * @return
     */
    // public static String filter(String str) {
    //     String output = "";
    //     StringBuffer sb = new StringBuffer();
    //     for (int i = 0; i < str.length(); i++) {
    //         int asc = str.charAt(i);
    //         if (asc != 10 && asc != 13) {
    //             sb.append(str.subSequence(i, i+1));
    //         }
    //     }
    //     output = new String(sb);
    //     return output;
    // }

    /**
     * 加密解密测试
     * @param args
     */
    // public static void main(String[] args) {
    //     try {
    //         String strText = "Hello world!";
    //         //加密
    //         String deseResult = desEncrypt(strText);
    //         System.out.println("加密结果："+deseResult);
    //         //解密
    //         String desdResult = desDecrypt(deseResult);
    //         System.out.println("解密结果："+desdResult);
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }
    // }
}
