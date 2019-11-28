package cn.knet.domain.enums;

import com.fasterxml.jackson.annotation.JsonValue;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public enum DomainAttachmentAuditEnum {

	UNCOMMITTED("UNCOMMITTED","未提交"), UPLOADED("UPLOADED", "提交中"),SUBMITTID("SUBMITTID", "已提交"),UNPASS("UNPASS","审核不通过"),PASS("PASS","审核通过");
	
	private static final Map<String, String> MAPPING = new LinkedHashMap<String, String>();

	private static final Map<String, String> INVERSE_MAPPING = new LinkedHashMap<String, String>();
	
	@ToJson
	private String value;
	
	@ToJson
	private String text;
	
	static {
		for (DomainAttachmentAuditEnum em : DomainAttachmentAuditEnum.values()) {
			MAPPING.put(em.getText(), em.getValue());
			INVERSE_MAPPING.put(em.getValue(), em.getText());
		}
	}

	/**
	 * 
	 * @param value
	 * @param text
	 */
	DomainAttachmentAuditEnum(final String value,final String text) {
		this.value = value;
		this.text = text;
	}
	
	public String getValue() {
		return value;
	}

	public String getText() {
		return text;
	}

	
	public static DomainAttachmentAuditEnum get(String enumValue) {
		for (DomainAttachmentAuditEnum em : DomainAttachmentAuditEnum.values()) {
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
	
}
