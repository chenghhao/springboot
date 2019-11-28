package cn.knet.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author xuxiannian
 * @since 2019-09-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("KNET_KEKE_TEMPLATE_VALUE")
public class KnetKekeTemplateValue implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID，主键唯一
     */
    @TableId("VID")
    private String vid;

    /**
     * 类型表ID
     */
    @TableField("TID")
    private String tid;

    /**
     * 排序SE
     */
    @TableField("SORT")
    private Double sort;

    /**
     * 是否保密
     */
    @TableField("SECRECY")
    private String secrecy;

    /**
     * 标签key
     */
    @TableField("NAME")
    private String name;

    /**
     * 标签value
     */
    @TableField("VALUE")
    private String value;

    /**
     * 类型type
     */
    @TableField("TYPE")
    private String type;

    /**
     * 类型type分类
     */
    @TableField("TYPE_NUM")
    private int typeNum;
}
