package com.asl.msmqdemo.handler;

import com.asl.msmqdemo.common.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Lance
 * @date 2021/1/7 13:35
 */

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = {RuntimeException.class})
    public Result<Object> handleOtherExceptions(final RuntimeException e) {
        logger.error(e.getMessage(), e);
        Result result = new Result();
        result.setCode(10001);
        result.setDesc(e.getMessage());
        return result;
    }

}
