package cn.knet.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author xuxiannian
 * @since 2019-09-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("KNET_KEKE_TEMPLATE")
public class KnetKekeTemplate implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 模板ID，主键唯一
     */
    @TableId("ID")
    private String id;

    /**
     * 模板名称
     */
    @TableField("NAME")
    private String name;

    /**
     * 封面
     */
    @TableField("COVER_IMG")
    private String coverImg;

    /**
     * 用户ID
     */
    @TableField("USER_ID")
    private String userId;

    /**
     * 头像
     */
    @TableField("VIDEO_URL")
    private String videoUrl;


    /**
     * 头像
     */
    @TableField("CREATE_DATE")
    private Date createDate;


    /**
     * 类型
     */
    @TableField("TOP_TYPE")
    private String topType;


}
