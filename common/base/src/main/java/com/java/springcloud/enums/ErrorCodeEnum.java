package com.java.springcloud.enums;

/**
 * ErrorCodeEnum
 *
 * @author TONE
 * @date 2019/8/9
 */
public enum ErrorCodeEnum {
    /**
     * SYS 99990100 error code enum.
     */
    SYS99990100(9999100, "参数异常"),
    /**
     * SYS 99990401 error code enum.
     */
    SYS99990401(99990401, "无访问权限"),
    /**
     * SYS 000500 error code enum.
     */
    SYS99990500(9999500, "未知异常"),
    /**
     * SYS 000403 error code enum.
     */
    SYS99990403(9999403, "无权访问"),
    /**
     * SYS 000404 error code enum.
     */
    SYS9999404(9999404, "找不到指定资源"),
    /**
     * SYS 99990001 error code enum.
     */
    SYS99990001(99990001, "注解使用错误"),
    /**
     * SYS 99990002 error code enum.
     */
    SYS99990002(99990002, "微服务不在线,或者网络超时"),
    /*1001 用户中心*/
    /**
     * UAC 10010001 error code enum.
     */
    UAC10010001(10010001, "会话超时,请刷新页面重试"),
    /**
     * UAC 10010002 error code enum.
     */
    UAC10010002(10010002, "TOKEN解析失败"),;

    private int code;
    private String msg;

    /**
     * Msg string.
     *
     * @return the string
     */
    public String msg() {
        return msg;
    }

    /**
     * Code int.
     *
     * @return the int
     */
    public int code() {
        return code;
    }

    ErrorCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * Gets enum.
     *
     * @param code the code
     *
     * @return the enum
     */
    public static ErrorCodeEnum getEnum(int code) {
        for (ErrorCodeEnum ele : ErrorCodeEnum.values()) {
            if (ele.code() == code) {
                return ele;
            }
        }
        return null;
    }
}
