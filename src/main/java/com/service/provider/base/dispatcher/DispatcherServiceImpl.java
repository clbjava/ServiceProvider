package com.service.provider.base.dispatcher;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.service.provider.base.DispatcherService;
import com.service.provider.base.ServiceConfig;

public class DispatcherServiceImpl implements InitializingBean, ApplicationContextAware, DispatcherService {

	private final Map<String, ServiceConfig> ServiceConfigs = new ConcurrentHashMap<String, ServiceConfig>();
	private ApplicationContext context;

	@Override
	public Object dispatcher(Map<String, Object> parameter) {
		Object object = null;
		try {
			object = ServiceConfigs.get("strategy-version").getMethod()
					.invoke(ServiceConfigs.get("strategy-version").getService(), parameter);
		} catch (Exception e) {

		}
		return object;
	}

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.context = context;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		Map<String, DispatcherService> services = context.getBeansOfType(DispatcherService.class);
		if (Optional.of(services).isPresent()) {
			services.values().stream().forEach(service -> {
				// TODO:加载ServiceConfig->ServiceConfigs
				ServiceConfigs.put("strategy-version", new ServiceConfig());
			});
		}
	}

}
