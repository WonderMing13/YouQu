package org.wonderming.result;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 王德明
 * @Date: 2018/12/12
 * @Time: 9:54
 * @Project: youqu
 * @Package: org.wonderming
 */
public class Result<T> {
    /**
     *  结果信息
     */
    private String message;
    /**
     *  状态码
     */
    private Integer code;
    /**
     *  返回数据
     */
    private T data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "message='" + message + '\'' +
                ", code=" + code +
                ", data=" + data +
                '}';
    }
}
