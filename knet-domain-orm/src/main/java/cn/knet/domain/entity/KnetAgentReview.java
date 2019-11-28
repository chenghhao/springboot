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
 * @since 2019-09-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("KNET_AGENT_REVIEW")
public class KnetAgentReview implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 公司名称
     */
    @TableField("ORG_NAME")
    private String orgName;

    /**
     * 网址
     */
    @TableField("ORG_URL")
    private String orgUrl;

    /**
     * 联系人
     */
    @TableField("CONTACTS")
    private String contacts;

    /**
     * 主营业务
     */
    @TableField("BUSINESS")
    private String business;

    /**
     * 电话
     */
    @TableField("TEL")
    private String tel;

    /**
     * 人员数量
     */
    @TableField("NUM")
    private String num;

    /**
     * 渠道
     */
    @TableField("SOURCE")
    private String source;

    /**
     * 备注
     */
    @TableField("REMARKS")
    private String remarks;

    @TableField("CREATE_DATE")
    private Date createDate;

    @TableId("ID")
    private String id;

    @TableField("STATUS")
    private String status;

    /**
     * 代理产品
     */
    @TableField("AGENT_PRODUCTS")
    private String agentProducts;

    /**
     * 电子邮箱
     */
    @TableField("EMAIL")
    private String email;


}
