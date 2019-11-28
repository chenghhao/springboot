package cn.knet.domain.entity;

import cn.knet.domain.enums.ProductTypeEnum;
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
 * 产品信息表
 * </p>
 *
 * @author xuxiannian
 * @since 2019-07-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("KNET_PRODUCT_INSTANCE")
public class KnetProductInstance implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 关联KNET_KETWORD表中的KW_ID、WLK_ID、DOMAIN_ID
     */
    @TableId("ID")
    private String id;

    /**
     * 关键字 [通用此字段存储代表字]
     */
    @TableField("KEYWORD")
    private String keyword;

    /**
     * 产品类型  kw-通用 wlk-无线 domain-域名
     */
    @TableField("PRO_TYPE")
    private ProductTypeEnum proType;

    /**
     * 注册商ID
     */
    @TableField("REGISTRAR_ID")
    private String registrarId;

    /**
     * 注册人ID
     */
    @TableField("REGISTRANT_ID")
    private String registrantId;

    /**
     * 注册时间
     */
    @TableField("REG_DATE")
    private Date regDate;

    /**
     * 到期时间
     */
    @TableField("EXPIRE_DATE")
    private Date expireDate;

    /**
     * 产品状态
     */
    @TableField("PRO_STATUS")
    private String proStatus;

    /**
     * 审核状态
     */
    @TableField("AUDIT_STATUS")
    private String auditStatus;

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
     * 通用URL
     */
    @TableField("URL")
    private String url;

    /**
     * 关联KNET_KEYWORD表的ID字段
     */
    @TableField("K_ID")
    private String kId;

    /**
     * 转移密码
     */
    @TableField("TRANS_PASSWORD")
    private String transPassword;

    /**
     * 网址密码
     */
    @TableField("PASSWORD")
    private String password;

    /**
     * 0-可升级 1-不可升级：域名验证不通过  2-不可升级：禁止词
     */
    @TableField("LEVELUP_TAG")
    private String levelupTag;

    @TableField("SALE_TEAM")
    private String saleTeam;

    /**
     * 资料URL地址
     */
    @TableField("ATTACHMENT_URL")
    private String attachmentUrl;

    /**
     * 资料状态
     */
    @TableField("ATTACHMENT_STATUS")
    private String attachmentStatus;

    /**
     * 资料审核原因
     */
    @TableField("ATTACHMENT_REASON")
    private String attachmentReason;

    @TableField("KEYWORD_TYPE")
    private String keywordType;

    @TableField("PUNYCODE")
    private String punycode;

    @TableField("AGENT_PASSWORD")
    private String agentPassword;

    @TableField("CLIENT_HOLD")
    private String clientHold;

    @TableField("CLIENT_HOLD_DATE")
    private Date clientHoldDate;

    /**
     * UNRES 未解析 , RESED 已解析, SUCCESS 解析成功
     */
    @TableField("RES_TYPE")
    private String resType;


}
