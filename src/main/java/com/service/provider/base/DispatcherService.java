package com.service.provider.base;

import java.util.Map;

public interface DispatcherService extends SuperService {

	Object dispatcher(Map<String, Object> parameter);

}
