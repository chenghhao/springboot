package cn.knet.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 易企秀
 * </p>
 *
 * @author xuxiannian
 * @since 2019-08-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("KNET_DNAME_EQXIU")
public class KnetDnameEqxiu implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("ID")
    private String id;

    @TableField("DOMAIN_ID")
    private String domainId;

    @TableField("DOMAIN")
    private String domain;

    @TableField("PID")
    private String pid;

    @TableField("HTML")
    private String html;

    @TableField("CREATE_DATE")
    private Date createDate;

    @TableField("UPDATE_DATE")
    private Date updateDate;

    @TableField("IPHONE")
    private String iphone;

    @TableField("MID")
    private String mid;


}
