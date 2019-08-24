package com.java.springcloud;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.springcloud.enums.ErrorCodeEnum;
import com.java.springcloud.exception.BusinessException;
import com.java.springcloud.enums.ErrorCodeEnum;
import com.java.springcloud.exception.BusinessException;
import com.netflix.hystrix.exception.HystrixBadRequestException;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.util.HashMap;

/**
 * Oauth2FeignErrorInterceptor
 *
 * @author TONE
 * @date 2019/8/12
 */
@Slf4j
public class Oauth2FeignErrorInterceptor implements ErrorDecoder {
    private final ErrorDecoder defaultErrorDecoder = new Default();

    /**
     * Decode exception.
     *
     * @param methodKey the method key
     * @param response  the response
     *
     * @return the exception
     */
    @Override
    public Exception decode(final String methodKey, final Response response) {
        if (response.status() >= HttpStatus.BAD_REQUEST.value() && response.status() < HttpStatus.INTERNAL_SERVER_ERROR.value()) {
            return new HystrixBadRequestException("request exception wrapper");
        }

        ObjectMapper mapper = new ObjectMapper();
        try {
            HashMap map = mapper.readValue(response.body().asInputStream(), HashMap.class);
            Integer code = (Integer) map.get("code");
            String message = (String) map.get("message");
            if (code != null) {
                ErrorCodeEnum anEnum = ErrorCodeEnum.getEnum(code);
                if (anEnum != null) {
                    if (anEnum == ErrorCodeEnum.SYS99990100) {
                        throw new IllegalArgumentException(message);
                    } else {
                        throw new BusinessException(anEnum);
                    }
                } else {
                    throw new BusinessException(ErrorCodeEnum.SYS99990500, message);
                }
            }
        } catch (IOException e) {
            log.info("Failed to process response body");
        }
        return defaultErrorDecoder.decode(methodKey, response);
    }
}
