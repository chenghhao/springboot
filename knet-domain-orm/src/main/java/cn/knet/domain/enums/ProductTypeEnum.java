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
 * 产品类型
 * @author xuxiannian
 * @version 1.0, 2014-5-22 
 * @since 1.0
 */
public enum ProductTypeEnum {
	wlk("wlk", "无线网址"),kw("kw", "通用网址"),domain("domain", "域名");

	private static final Map<String, String> MAPPING = new LinkedHashMap<String, String>();

	private static final Map<String, String> INVERSE_MAPPING = new LinkedHashMap<String, String>();
	@ToJson
	private String value;
	@ToJson
	private String text;

	static {
		for (ProductTypeEnum em : ProductTypeEnum.values()) {
			MAPPING.put(em.getText(), em.getValue());
			INVERSE_MAPPING.put(em.getValue(), em.getText());
		}
	}

	/**
	 * 
	 * @param value
	 * @param text
	 */
	ProductTypeEnum(final String value, final String text) {
		this.value = value;
		this.text = text;
	}

	public String getValue() {
		return value;
	}

	
	public String getText() {
		return text;
	}

	
	public static ProductTypeEnum get(String enumValue) {
		for (ProductTypeEnum em : ProductTypeEnum.values()) {
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
	
	
	public static boolean isKw(ProductTypeEnum type) {
		return ProductTypeEnum.kw.equals(type);
	}

	public static boolean isWlk(ProductTypeEnum type) {
		return ProductTypeEnum.wlk.equals(type);
	}

	public static boolean isDomain(ProductTypeEnum type) {
		return ProductTypeEnum.domain.equals(type);
	}
}
