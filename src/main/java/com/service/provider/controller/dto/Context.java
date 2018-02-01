package com.service.provider.controller.dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Context implements Map<String, Object>, Cloneable, Serializable {

	private static final long serialVersionUID = 3676812243691688527L;
	private final static int DEFAULT_INITIAL_CAPACITY = 1 << 4;
	private final Map<String, Object> map;
	
	/**
	 * 策略类型
	 */
	private String busType;
	
	/**
	 * 策略类型版本号
	 */
	private String busVersion;

	public Context() {
		this(DEFAULT_INITIAL_CAPACITY);
	}

	public Context(int capacity) {
		map = new HashMap<String, Object>(capacity);
	}

	@Override
	public int size() {
		return map.size();
	}

	@Override
	public boolean isEmpty() {
		return map.isEmpty();
	}

	@Override
	public boolean containsKey(Object key) {
		return map.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return map.containsValue(value);
	}

	@Override
	public Object get(Object key) {
		return map.get(key);
	}

	@Override
	public Object put(String key, Object value) {
		return map.put(key, value);
	}

	@Override
	public Object remove(Object key) {
		return map.remove(key);
	}

	@Override
	public void putAll(Map<? extends String, ? extends Object> m) {
		map.putAll(m);
		;
	}

	@Override
	public void clear() {
		map.clear();
	}

	@Override
	public Set<String> keySet() {
		return map.keySet();
	}

	@Override
	public Collection<Object> values() {
		return map.values();
	}

	@Override
	public Set<Entry<String, Object>> entrySet() {
		return map.entrySet();
	}

	public String getBusType() {
		return busType;
	}

	public void setBusType(String busType) {
		this.busType = busType;
	}

	public String getBusVersion() {
		return busVersion;
	}

	public void setBusVersion(String busVersion) {
		this.busVersion = busVersion;
	}
    
}
