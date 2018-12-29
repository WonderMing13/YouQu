package org.wonderming.utils;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 王德明
 * @Date: 2018/12/17
 * @Time: 11:56
 * @Project: youqu
 * @Package: org.wonderming.utils
 */
public class JsonUtils {

    /**
     *  定义Jackson对象
     */
    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final Logger JSONPARSE_LOGGER = LoggerFactory.getLogger(JsonUtils.class);

    /**
     * 将对象转换成JSON字符串
     * @param data
     * @return
     */
    public static String objectToJson(Object data) {
        try {
            return MAPPER.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            JSONPARSE_LOGGER.error("JsonUtils解析出错",e);
        }
        return null;
    }

    /**
     * 将对象转换成json字符串空字段不添加。
     *
     * @param data
     * @return
     */
    public static String objectToJsonNonNull(Object data) {
        try {
            MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            return MAPPER.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            JSONPARSE_LOGGER.error("JsonUtils解析出错", e);
        }
        return null;
    }

    /**
     * 将JSON字符串转换成对象
     * @param jsonData
     * @param beanType
     * @param <T>
     * @return
     */
    public static <T> T jsonToPojo(String jsonData,Class<T> beanType) {
        try {
            T t = MAPPER.readValue(jsonData, beanType);
            return t;
        } catch (Exception e) {
            JSONPARSE_LOGGER.error("JsonUtils转换出错",e);
        }
        return null;
    }

    /**
     * 将JSON字符串转换成pojo对象List
     * @param jsonData
     * @param beanType
     * @param <T>
     * @return
     */
    public static <T> List<T> jsonToList(String jsonData,Class<T> beanType) {
        JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class,beanType);
        try {
            List<T> list = MAPPER.readValue(jsonData, javaType);
            return list;
        } catch (Exception e) {
            JSONPARSE_LOGGER.error("JsonUtils转换出错",e);
        }
        return null;
    }

    /**
     * 如：Map<String, Object> -> jsonToPojo(String jsonData, Map.class, String.class, Object.class)
     * @param jsonData
     * @param beanType 个数不确定的实参
     * @param elementType
     * @param <T>
     * @return
     */
    public static <T> T jsonToCollection(String jsonData,Class<T> beanType,Class<?>... elementType) {
        JavaType javaType = MAPPER.getTypeFactory().constructParametricType(beanType,elementType);
        try {
            return MAPPER.readValue(jsonData,javaType);
        } catch (Exception e) {
            JSONPARSE_LOGGER.error("JsonUtils转换出错",e);
        }
        return null;
    }
}
