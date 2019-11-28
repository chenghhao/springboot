package cn.knet.domain.enums;

public enum StatusEnum {
	ABLE("ABLE","正常"),
	DISABLE("DISABLE","停用");

	private StatusEnum(String value, String text) {
		this.value = value;
		this.text = text;
	}
	String value;
	String text;
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	
}
