/*
 * @(#)Audit.java 2013-8-14
 *
 * Copyright 2011 北龙中网（北京）科技有限责任公司. All rights reserved.
 */
package cn.knet.domain.enums;

import com.fasterxml.jackson.annotation.JsonValue;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 审核操作的类型
 * @author xuxiannian
 * @version 1.0, 2014-5-22 
 * @since 1.0
 */
public enum ProductStatusEnum {

	OK("OK","A","OK", "正常"),
	SERVICE_HOLD("SERVICE_HOLD","SERVICE_HOLD","SERVICE_HOLD", "冻结"),
	RESERVE("RESERVE","R","RESERVE", "预留"),
	PENDING_DELETE("PENDING_DELETE","D","pendingDelete", "保留期"), 
	PENDING_TRANSFER("PENDING_TRANSFER", "T", "pendingTransfer", "转移中"),
	PENDING_MOD("PENDING_MOD", "M", "pendingMod", "变更中"),
	PENDING_UPDATE("PENDING_UPDATE", "U", "pendingUpdate", "过户中");
	
	private static final Map<String, String> MAPPING = new LinkedHashMap<String, String>();

	private static final Map<String, String> INVERSE_MAPPING = new LinkedHashMap<String, String>();
	@ToJson
	private String value;
	@ToJson
	private String kw;
	@ToJson
	private String wlk;
	@ToJson
	private String text;

	static {
		for (ProductStatusEnum em : ProductStatusEnum.values()) {
			MAPPING.put(em.getText(), em.getValue());
			INVERSE_MAPPING.put(em.getValue(), em.getText());
		}
	}

	/**
	 * 
	 * @param value
	 * @param text
	 */
	ProductStatusEnum(final String value,  final String kw, final String wlk,final String text) {
		this.value = value;
		this.text = text;
		this.kw = kw;
		this.wlk = wlk;
	}
	public String getValue() {
		return value;
	}

	public String getText() {
		return text;
	}

	
	public static ProductStatusEnum get(String enumValue) {
		for (ProductStatusEnum em : ProductStatusEnum.values()) {
			if (em.getValue().equals(enumValue)) {
				return em;
			}
		}
		throw new IllegalArgumentException("Can't get enum with this enumValue.");
	}

	/**
	 * 
	 * @return
	 */
	public static Map<String, String> mapping() {
		return MAPPING;
	}

	/**
	 * 
	 * @return
	 */
	public static Map<String, String> inverseMapping() {
		return INVERSE_MAPPING;
	}

	public String getKw() {
		return kw;
	}

	public String getWlk() {
		return wlk;
	}
	
	@JsonValue
	public Map<String, Object> jsonValue() throws IllegalArgumentException, IllegalAccessException {
		Map<String, Object> map  = new HashMap<String, Object>();
		Field[] fields = getClass().getDeclaredFields();
		for (Field f : fields) {
			ToJson toJson = f.getAnnotation(ToJson.class);
			if (toJson != null) {
				f.setAccessible(true);
				Object v = f.get(this);
				map.put(f.getName(), v);	
			}
		}
		return map;
	}
	
}
