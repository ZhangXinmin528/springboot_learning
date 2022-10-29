package com.imooc.starter.exception;

import com.imooc.starter.utils.JsonResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常拦截处理
 * 可以针对异常去处理去捕获，返回指定的类型（json类型）到前端
 */
@ControllerAdvice
public class GeaceExceptionHandler {

    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public JsonResult returnCustomException(CustomException exception) {
        return JsonResult.error(-1, exception.getMessage(), null);
    }
}
