package com.service.provider.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import com.service.provider.service.ServiceTemplate;


@RestController
@RequestMapping("server")
public class BaseController extends AbstractController {
	
	private final static Logger LOGGER=LoggerFactory.getLogger(BaseController.class);
	
	@Qualifier("servicesExecutor")
	@Autowired
	ThreadPoolTaskExecutor threadPoolTaskExecutor;
    
	@RequestMapping(value = "apply", method = RequestMethod.GET)
	public DeferredResult<String> query(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			@RequestParam(value = "id", required = false) String id) {
		LOGGER.info("BaseController.apply:{}", id);
		return this.execute(httpServletRequest, httpServletResponse, id, new ServiceTemplate<String, String>() {
			@Override
			public String execute(String request) {
				LOGGER.info("ServiceTemplate.execute:{}", id);
				return "hello world!";
			}

		}, 5000);
	}

	@Override
	protected ThreadPoolTaskExecutor getThreadPoolTaskExecutor() {
		return threadPoolTaskExecutor;
	}
}
