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
 * @since 2019-11-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("KNET_OFFICIAL_INDUSTRY_CASE")
public class KnetOfficialIndustryCase implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("ID")
    private String id;

    /**
     * knet_official_industry的id
     */
    @TableField("I_ID")
    private String iId;

    /**
     * 域名
     */
    @TableField("DOMAIN")
    private String domain;

    /**
     * 图片链接
     */
    @TableField("URL")
    private String url;

    /**
     * 图标星级
     */
    @TableField("CLEVEL")
    private Integer clevel;


}
