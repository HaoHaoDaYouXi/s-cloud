package com.java.springcloud.app;

/**
 * AppSecretException
 *
 * @author TONE
 * @date 2019/8/12
 */
public class AppSecretException extends RuntimeException {

    /**
     * Instantiates a new App secret exception.
     *
     * @param msg the msg
     */
    public AppSecretException(String msg) {
        super(msg);
    }
}
