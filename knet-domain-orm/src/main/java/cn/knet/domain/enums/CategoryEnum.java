package cn.knet.domain.enums;

import com.fasterxml.jackson.annotation.JsonValue;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author dcx
 * @create 2019-11-27 13:55
 */
public enum CategoryEnum {

    one ("one",10, "general", "普通通用网址", "common", "普通网址", "2","普通域名","Common"),
    two ("two",20, "zhun", "准通用词", "normal", "精品网址", "3","精品域名","Silver"),
    three ("three",30, "normal", "普通通用词", "gold", "行业网址", "1","行业域名","Gold"),
    four ("four",40, "gold", "白金词", "diamond", "白金网址", "4","白金域名","Platinum"),
    name ("name",50, "name", "姓名网址", "name", "姓名网址", "5","姓名网址","name"),
    org_name ("org_name",50, "org_name", "企业简称", "org_name", "企业简称", "5","企业简称","org_name"),
    brand ("brand",60, "brand", "品牌网址", "brand", "品牌网址", "6","品牌域名","brand");


    private static final Map<String, String> MAPPING = new LinkedHashMap<String, String>();

    private static final Map<String, String> INVERSE_MAPPING = new LinkedHashMap<String, String>();

    @ToJson
    String key;
    @ToJson
    int value;
    @ToJson
    String kwEn;
    @ToJson
    String kwCn;
    @ToJson
    String wlkEn;
    @ToJson
    String wlkCn;
    @ToJson
    String  wlkCode;
    @ToJson
    String domainCn;
    @ToJson
    String domainEn;


    static {
        for (CategoryEnum em : CategoryEnum.values()) {
            MAPPING.put(em.getKwCn()+"/"+em.getWlkCn(), em.getValue()+"");
            INVERSE_MAPPING.put(em.getValue()+"", em.getKwCn()+"/"+em.getWlkCn());
        }
    }

    private CategoryEnum(String key,int value, String kwEn, String kwCn, String wlkEn, String wlkCn, String wlkCode,String domainCn,String domainEn) {
        this.key = key;
        this.value = value;

        this.kwEn = kwEn;
        this.kwCn = kwCn;

        this.wlkEn = wlkEn;
        this.wlkCn = wlkCn;

        this.wlkCode = wlkCode;
        this.domainCn=domainCn;
        this.domainEn=domainEn;
    }

    public static Map<String, String> mapping() {
        return MAPPING;
    }

    public static Map<String, String> inverseMapping() {
        return INVERSE_MAPPING;
    }

    public static CategoryEnum get(String enumValue) {
        for (CategoryEnum em : CategoryEnum.values()) {
            if (em.getKey().equals(enumValue)) {
                return em;
            }
        }
        throw new IllegalArgumentException("Can't get enum with this enumValue.");
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



    public int getValue() {
        return value;
    }



    public void setValue(int value) {
        this.value = value;
    }



    public String getKwEn() {
        return kwEn;
    }



    public void setKwEn(String kwEn) {
        this.kwEn = kwEn;
    }



    public String getKwCn() {
        return kwCn;
    }



    public void setKwCn(String kwCn) {
        this.kwCn = kwCn;
    }



    public String getWlkEn() {
        return wlkEn;
    }



    public void setWlkEn(String wlkEn) {
        this.wlkEn = wlkEn;
    }



    public String getWlkCn() {
        return wlkCn;
    }



    public void setWlkCn(String wlkCn) {
        this.wlkCn = wlkCn;
    }



    public String getWlkCode() {
        return wlkCode;
    }



    public void setWlkCode(String wlkCode) {
        this.wlkCode = wlkCode;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDomainCn() {
        return domainCn;
    }

    public void setDomainCn(String domainCn) {
        this.domainCn = domainCn;
    }

    public String getDomainEn() {
        return domainEn;
    }

    public void setDomainEn(String domainEn) {
        this.domainEn = domainEn;
    }
}
