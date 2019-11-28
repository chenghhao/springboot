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
 * 
 * </p>
 *
 * @author xuxiannian
 * @since 2019-09-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("KNET_AGENT")
public class KnetAgent implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("U_ID")
    private String uId;

    /**
     * 注册商名称
     */
    @TableField("NAME")
    private String name;

    @TableField("SUPPORT_ID")
    private String supportId;

    @TableField("CREATE_DATE")
    private Date createDate;

    @TableField("REG_FLAG")
    private String regFlag;

    @TableField("STATUS")
    private String status;

    @TableField("AUDIT_ID")
    private String auditId;

    @TableField("AUDIT_REASON")
    private String auditReason;

    @TableField("AUDIT_DATE")
    private Date auditDate;

    @TableField("CLOSE_DATE")
    private Date closeDate;

    @TableField("EMAIL")
    private String email;

    @TableField("SELL_AREA")
    private String sellArea;

    /**
     * 端口开通提醒，0未提醒；1提醒
     */
    @TableField("REMIND")
    private String remind;

    /**
     * 端口开通提醒日期
     */
    @TableField("REMIND_DATE")
    private Date remindDate;

    @TableField("AGENT_REGISTRANT_ID")
    private String agentRegistrantId;

    /**
     * 是否推送业绩Y,N
     */
    @TableField("IS_SSMS")
    private String isSsms;

    /**
     * 客服邮箱
     */
    @TableField("CUSTOMER_EMAIL")
    private String customerEmail;


}
