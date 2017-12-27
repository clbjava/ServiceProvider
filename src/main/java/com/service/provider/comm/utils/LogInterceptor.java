package com.service.provider.comm.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LogInterceptor implements HandlerInterceptor {

  
    private final static String SESSION_TOKEN_KEY = "sessionTokenId";
    private static final Logger LOGGER = LoggerFactory.getLogger(LogInterceptor.class);


	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		LOGGER.info("preHandle");
        String token = java.util.UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
        MDC. put(SESSION_TOKEN_KEY, token);
        return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		 MDC. remove(SESSION_TOKEN_KEY);
		
	}
}

