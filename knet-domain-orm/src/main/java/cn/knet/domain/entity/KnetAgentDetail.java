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
 * @since 2019-08-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("KNET_AGENT_DETAIL")
public class KnetAgentDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("U_ID")
    private String uId;

    @TableField("URL")
    private String url;

    @TableField("ADDRESS")
    private String address;

    @TableField("POSTCODE")
    private String postcode;

    @TableField("FAX")
    private String fax;

    @TableField("SCALE")
    private String scale;

    @TableField("BUSINESS")
    private String business;

    @TableField("SALER_NUM")
    private Double salerNum;

    @TableField("LEGAL_NAME")
    private String legalName;

    @TableField("LEGAL_TEL")
    private String legalTel;

    @TableField("MANAGER_NAME")
    private String managerName;

    @TableField("MANAGER_TEL")
    private String managerTel;

    @TableField("CONTACT_NAME")
    private String contactName;

    @TableField("CONTACT_TEL")
    private String contactTel;

    @TableField("CONTACT_PHONE")
    private String contactPhone;

    @TableField("CONTACT_TITLE")
    private String contactTitle;

    @TableField("CONTACT_BIRTH")
    private Date contactBirth;

    @TableField("CONTACT_QQ")
    private String contactQq;

    @TableField("IS_SHOW")
    private String isShow;


}
