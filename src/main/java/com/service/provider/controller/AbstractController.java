package com.service.provider.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.context.request.async.DeferredResult;

import com.service.provider.controller.dto.BaseResult;
import com.service.provider.service.ServiceTemplate;

public abstract class AbstractController {

	protected abstract ThreadPoolTaskExecutor getThreadPoolTaskExecutor();

	protected <E, T> DeferredResult<BaseResult<T>> execute(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse, E request, ServiceTemplate<E, T> serviceTemplate, long timeOut) {

		DeferredResult<BaseResult<T>> result = new DeferredResult<BaseResult<T>>();

		DeferredResultRunable<E, T> task = new DeferredResultRunable<E, T>(request, serviceTemplate, result);
		getThreadPoolTaskExecutor().submit(task);

		return result;
	}

	private class DeferredResultRunable<E, T> implements Runnable {

		private ServiceTemplate<E, T> serviceTemplate;
		E request;
		private DeferredResult<BaseResult<T>> result;

		public DeferredResultRunable(E request, ServiceTemplate<E, T> serviceTemplate,
				DeferredResult<BaseResult<T>> result) {
			this.request = request;
			this.serviceTemplate = serviceTemplate;
			this.result = result;
		}

		@Override
		public void run() {
			T t = serviceTemplate.execute(request);
			BaseResult<T> back = new BaseResult<T>();
			back.setResult(t);
			result.setResult(back);
		}
	}

}
