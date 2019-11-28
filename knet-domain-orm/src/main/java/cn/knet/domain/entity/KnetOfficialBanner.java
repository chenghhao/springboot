package cn.knet.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 官网banner表
 * </p>
 *
 * @author xuxiannian
 * @since 2019-11-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("KNET_OFFICIAL_BANNER")
public class KnetOfficialBanner implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("ID")
    private String id;

    /**
     * 图片存放路径
     */
    @TableField("IMAGE")
    private String image;

    /**
     * 状态Y为可用  N为不可用
     */
    @TableField("STATUS")
    private String status;

    @TableField("CREATE_DATE")
    private Date createDate;

    /**
     * 存放顺序
     */
    @TableField("SORT")
    private Double sort;

    /**
     * 连接跳转地址
     */
    @TableField("URL")
    private String url;


}
