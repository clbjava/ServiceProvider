package com.service.provider.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import com.service.provider.controller.dto.BaseResult;
import com.service.provider.controller.dto.Context;
import com.service.provider.service.ServiceTemplate;

@RestController
@RequestMapping("serviceProvider")
public class BaseController extends AbstractController {

	private final static Logger LOGGER = LoggerFactory.getLogger(BaseController.class);

	@Qualifier("servicesExecutor")
	@Autowired
	ThreadPoolTaskExecutor threadPoolTaskExecutor;

	@RequestMapping(value = "get/{uri}", method = RequestMethod.GET)
	public DeferredResult<BaseResult<Context>> get(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse,
			@PathVariable("uri") String uri,
			@RequestParam(value = "busType", required = true) String busType,
			@RequestParam(value = "busVersion", required = true) String busVersion,
			@RequestParam(value = "requestBody", required = false) String jsonString) throws Exception {
		LOGGER.info("BaseController.get:busType={},busVersion={},requestBody={}", busType, busVersion, jsonString);
		Context context = new Context();
		context.put("hello", "jsonString");
		return this.execute(httpServletRequest, httpServletResponse, context, new ServiceTemplate<Context, Context>() {
			@Override
			public Context execute(Context context) {
				Context result = new Context();
				result.put("hello", "world");
				return result;
			}

		}, 5000);
	}

	@RequestMapping(value = "post/{uri}", method = RequestMethod.POST)
	public DeferredResult<BaseResult<Context>> post(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse, 
			@PathVariable("uri") String uri,
			@RequestParam(value = "busType", required = true) String busType,
			@RequestParam(value = "busVersion", required = true) String busVersion, @RequestBody Context context) {
		LOGGER.info("BaseController.post:busType={},busVersion={},requestBody={}", busType, busVersion, context);
		return this.execute(httpServletRequest, httpServletResponse, context, new ServiceTemplate<Context, Context>() {
			@Override
			public Context execute(Context context) {
				Context result = new Context();
				result.put("hello", "world");
				return result;
			}
		}, 5000);
	}

	@Override
	protected ThreadPoolTaskExecutor getThreadPoolTaskExecutor() {
		return threadPoolTaskExecutor;
	}
}
