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
@TableName("KNET_KEKE_TEMPLATE_TYPE")
public class KnetKekeTemplateType implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID，主键唯一
     */
    @TableId("TID")
    private String tid;

    /**
     * 模板ID
     */
    @TableField("MID")
    private String mid;

    /**
     * 排序
     */
    @TableField("SORT")
    private Double sort;

    /**
     * 类型
     */
    @TableField("TYPE")
    private String type;

    /**
     * 类型
     */
    @TableField("TYPE_NUM")
    private int typeNum;


}
