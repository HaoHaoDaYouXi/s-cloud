package com.java.springcloud.exception;

import com.java.springcloud.enums.ErrorCodeEnum;
import com.java.springcloud.enums.ErrorCodeEnum;
import lombok.extern.slf4j.Slf4j;

/**
 * BusinessException
 *
 * @author TONE
 * @date 2019/8/12
 */
@Slf4j
public class BusinessException extends RuntimeException {

    /**
     * 异常码
     */
    protected int code;

    public BusinessException() {
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(int code, String msgFormat, Object... args) {
        super(String.format(msgFormat, args));
        this.code = code;
    }

    public BusinessException(ErrorCodeEnum codeEnum, Object... args) {
        super(String.format(codeEnum.msg(), args));
        this.code = codeEnum.code();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
