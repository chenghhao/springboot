package cn.knet.domain.entity;

import cn.knet.domain.enums.RegistrantTypeEnum;
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
 * 注册人表
 * </p>
 *
 * @author xuxiannian
 * @since 2019-08-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("KNET_REGISTRANT")
public class KnetRegistrant implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 注册人ID [通用格式：注册商ID_注册人ID]
     */
    @TableId("REGISTRANT_ID")
    private String registrantId;

    /**
     * 注册商ID
     */
    @TableField("REGISTRAR_ID")
    private String registrarId;

    /**
     * 只通用使用：注册人ID
     */
    @TableField("KW_OLD_REGISTRANT_ID")
    private String kwOldRegistrantId;

    /**
     * 密码
     */
    @TableField("PASSWORD")
    private String password;

    /**
     * 联系人姓名
     */
    @TableField("CONTACT_NAME")
    private String contactName;

    /**
     * 联系地址
     */
    @TableField("ADDRESS")
    private String address;

    /**
     * 邮箱
     */
    @TableField("EMAIL")
    private String email;

    /**
     * 国家地区编号
     */
    @TableField("INTERNAL_CODE")
    private String internalCode;

    /**
     * 省份
     */
    @TableField("PROVINCE")
    private String province;

    /**
     * 城市
     */
    @TableField("CITY")
    private String city;

    /**
     * 手机
     */
    @TableField("MOBILE")
    private String mobile;

    /**
     * 电话
     */
    @TableField("TELEPHONE")
    private String telephone;

    /**
     * 传真
     */
    @TableField("FAX")
    private String fax;

    /**
     * 邮政地址信息模式
     */
    @TableField("POSTAL_MODEL")
    private String postalModel;

    /**
     * 交易识别号
     */
    @TableField("TRADE_CODE")
    private String tradeCode;

    /**
     * 邮编
     */
    @TableField("ZIPCODE")
    private String zipcode;

    /**
     * 用户类型 (I-个人 E-企业)
     */
    @TableField("REGISTRANT_TYPE")
    private RegistrantTypeEnum registrantType;

    /**
     * 注册者名称
     */
    @TableField("REGISTRANT_NAME")
    private String registrantName;

    /**
     * 证件类型 (I1-身份证 I2-军官证 I3-护照 E1-营业执照 E2-组织机构代码)
     */
    @TableField("ID_TYPE")
    private String idType;

    /**
     * 证件号码
     */
    @TableField("ID_NUMBER")
    private String idNumber;

    /**
     * 创建时间
     */
    @TableField("CREATE_DATE")
    private Date createDate;

    /**
     * 修改时间
     */
    @TableField("UPDATE_DATE")
    private Date updateDate;

    /**
     * 电话-国际区号
     */
    @TableField("TELEPHONE_INTL")
    private String telephoneIntl;

    /**
     * 传真-国际区号
     */
    @TableField("FAX_INTL")
    private String faxIntl;

    /**
     * 域名关联的联系人ID
     */
    @TableField("DOMAIN_REGISTRANT_ID")
    private String domainRegistrantId;

    /**
     * 电话分机
     */
    @TableField("TELEPHONE_EXT")
    private String telephoneExt;

    /**
     * 传真分机
     */
    @TableField("FAX_EXT")
    private String faxExt;

    /**
     * 手机国别号，默认86
     */
    @TableField("MOBILE_INTL")
    private String mobileIntl;

    /**
     * 是否经过邮件激活，默认false
     */
    @TableField("EMAIL_ACTIVE")
    private String emailActive;

    /**
     * 审核状态，默认未审核，未审核的注册人不能注册
     */
    @TableField("AUDIT_STATUS")
    private String auditStatus;

    /**
     * 组织结构，个人用户没有组织字段
     */
    @TableField("ORGANIZATION")
    private String organization;

    /**
     * 注册人审核资料，存在图片服务器，json格式
     */
    @TableField("AUDIT_DETAIL")
    private String auditDetail;

    /**
     * 隐私协议，签署隐私协议，在add和update中，会传输特定的联系人信息
     */
    @TableField("PRIVACY")
    private String privacy;

    @TableField("AUDIT_FILE")
    private String auditFile;

    @TableField("STATUS")
    private String status;

    @TableField("REMARK")
    private String remark;

    @TableField("OTHER_FILE1")
    private String otherFile1;

    @TableField("OTHER_FILE2")
    private String otherFile2;

    @TableField("OTHER_FILE3")
    private String otherFile3;

    @TableField("OTHER_FILE4")
    private String otherFile4;

    /**
     * 审核员
     */
    @TableField("AUDITOR")
    private String auditor;

    @TableField("LAST_UPLOADING_DATE")
    private Date lastUploadingDate;

    /**
     * 提交审核时间
     */
    @TableField("LAST_AUDITING_DATE")
    private Date lastAuditingDate;

    /**
     * 审核时间
     */
    @TableField("AUDIT_DATE")
    private Date auditDate;

    @TableField("CONFIRM_STATUS")
    private String confirmStatus;

    @TableField("CONFIRM_DATE")
    private Date confirmDate;

    @TableField("CONFIRM_IP")
    private String confirmIp;

    @TableField("IS_PHONE_CONFIRM")
    private String isPhoneConfirm;

    @TableField("PHONE_CONFIRM_DATE")
    private Date phoneConfirmDate;

    /**
     * 激活email
     */
    @TableField("EMAIL_ACTIVATE")
    private String emailActivate;

    /**
     * 激活手机号
     */
    @TableField("PHONE_ACTIVATE")
    private String phoneActivate;

    @TableField("COM_CREATE_DATE")
    private String comCreateDate;

    @TableField("COM_CAPITAL")
    private String comCapital;

    @TableField("COM_TYPE")
    private String comType;


}
