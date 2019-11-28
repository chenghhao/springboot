package cn.knet.domain.enums;

/**
 * 服务类型
 * 
 * ClassName: ServiceTypeEnum <br/>  
 * Date: 2017年3月14日 上午11:44:05 <br/> 
 *  
 * @author 杨小白
 * @version 1.0
 * @since 1.0
 * @see
 */
public enum ResolutionTypeEnum {
    UNRES("UNRES","未解析"),
    RESED("RESED","已解析"),
	SUCCESS("SUCCESS","解析成功");
	
	private ResolutionTypeEnum(String value, String text) {
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
