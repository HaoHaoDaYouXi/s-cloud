package com.java.springcloud.web;

import com.java.springcloud.enums.ErrorCodeEnum;
import com.java.springcloud.exception.BusinessException;
import com.java.springcloud.util.wrapper.WrapMapper;
import com.java.springcloud.util.wrapper.Wrapper;
import com.java.springcloud.enums.ErrorCodeEnum;
import com.java.springcloud.exception.BusinessException;
import com.java.springcloud.util.wrapper.WrapMapper;
import com.java.springcloud.util.wrapper.Wrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.task.TaskExecutor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.annotation.Resource;

/**
 * GlobalExceptionHandler
 * 全局的的异常拦截器
 *
 * @author TONE
 * @date 2019/8/15
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @Resource
    private TaskExecutor taskExecutor;
    @Value("${spring.profiles.active}")
    String profile;
    @Value("${spring.application.name}")
    String applicationName;
    /*@Resource
    private MdcExceptionLogFeignApi mdcExceptionLogFeignApi;*/

    /**
     * 参数非法异常.
     *
     * @param e the e
     *
     * @return the wrapper
     */
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Wrapper illegalArgumentException(IllegalArgumentException e) {
        log.error("参数非法异常={}", e.getMessage(), e);
        return WrapMapper.wrap(ErrorCodeEnum.SYS99990100.code(), e.getMessage());
    }

    /**
     * 业务异常.
     *
     * @param e the e
     *
     * @return the wrapper
     */
    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Wrapper businessException(BusinessException e) {
        log.error("业务异常={}", e.getMessage(), e);
        return WrapMapper.wrap(e.getCode() == 0 ? Wrapper.ERROR_CODE : e.getCode(), e.getMessage());
    }

    /**
     * 无权限访问.
     *
     * @param e the e
     *
     * @return the wrapper
     */
    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public Wrapper unAuthorizedException(AccessDeniedException e) {
        log.error("业务异常={}", e.getMessage(), e);
        return WrapMapper.wrap(ErrorCodeEnum.SYS99990401.code(), ErrorCodeEnum.SYS99990401.msg());
    }


    /**
     * 全局异常.
     *
     * @param e the e
     *
     * @return the wrapper
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public Wrapper exception(Exception e) {
        log.info("保存全局异常信息 ex={}", e.getMessage(), e);
        /*taskExecutor.execute(() -> {
            GlobalExceptionLogDto globalExceptionLogDto = new GlobalExceptionLogDto().getGlobalExceptionLogDto(e, profile, applicationName);
            mdcExceptionLogFeignApi.saveAndSendExceptionLog(globalExceptionLogDto);
        });*/
        return WrapMapper.error();
    }
}
