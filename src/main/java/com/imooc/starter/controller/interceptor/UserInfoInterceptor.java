package com.imooc.starter.controller.interceptor;

import com.imooc.starter.exception.GraceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * SpringBoot实现拦截器功能
 * 用户信息拦截器
 */
@Slf4j
public class UserInfoInterceptor implements HandlerInterceptor {

    /**
     * 拦截请求，访问controller之前
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        final String userId = request.getHeader("userId");
        final String userToken = request.getHeader("userToken");
        if (StringUtils.isEmpty(userId) || StringUtils.isEmpty(userToken)) {
            log.error("用户校验不通过，信息不完整！");
            GraceException.display("用户校验不通过，信息不完整！");
            return false;
        }

        //假设正式的用户id 是 1001，用户token是abcxyz
        if (!userId.equalsIgnoreCase("1001") ||
                !userToken.equalsIgnoreCase("abcxyz")) {
            log.error("用户权限不通过");
            GraceException.display("用户权限不通过");
            return false;
        }


        //false:请求被拦截;
        //true:请求放行，可以继续访问后面的controller
        return true;
    }

    /**
     * 请求访问到controller之后，视图渲染之前
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    /**
     * 请求访问到controller之后，渲染视图之后
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
