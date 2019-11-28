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
 * 
 * @author xuxiannian
 * @version 1.0, 2014-5-22
 * @since 1.0
 */
public enum KeywordTypeEnum {
	NAME("NAME", "姓名网址", 1), NORMAL("NORMAL", "普通网址", 1), ORG_NAME("ORG_NAME", "企业简称网址", 1), TUIGUANG("TUIGUANG",
			"区域推广", 0), PINPAI("PINPAI", "品牌", 0), TONGYONG("TONGYONG", "通用词",
					0), DICHAN("DICHAN", "地区产品", 0), PINGTAI("PINGTAI", "在线平台", 0), JIANCHENG("JIANCHENG", "简称", 0);

	private static final Map<String, String> MAPPING = new LinkedHashMap<String, String>();

	private static final Map<String, String> INVERSE_MAPPING = new LinkedHashMap<String, String>();

	@ToJson
	private String value;

	@ToJson
	private String text;
	/**
	 * 1.固有类型不可修改 0.人工标记类型，可修改。
	 */
	@ToJson
	private int flag;

	static {
		for (KeywordTypeEnum em : KeywordTypeEnum.values()) {
			MAPPING.put(em.getText(), em.getValue());
			INVERSE_MAPPING.put(em.getValue(), em.getText());
		}
	}

	/**
	 * 
	 * @param value
	 * @param text
	 */
	KeywordTypeEnum(final String value, final String text, int flag) {
		this.value = value;
		this.text = text;
		this.flag = flag;
	}

	public String getValue() {
		return value;
	}

	public String getText() {
		return text;
	}
	
	public int getFlag() {
		return flag;
	}

	public static KeywordTypeEnum get(String enumValue) {
		for (KeywordTypeEnum em : KeywordTypeEnum.values()) {
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
		Map<String, Object> map = new HashMap<String, Object>();
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
