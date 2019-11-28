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
 * @since 2019-09-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("KNET_AGENT_FEE_DETAIL")
public class KnetAgentFeeDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 唯一标识
     */
    @TableId("ID")
    private String id;

    /**
     * 代理商ID
     */
    @TableField("AGENT_ID")
    private String agentId;

    /**
     * 操作类型
     */
    @TableField("OP_TYPE")
    private String opType;

    /**
     * 操作时间
     */
    @TableField("OP_DATE")
    private Date opDate;

    /**
     * 费用
     */
    @TableField("FEE")
    private Double fee;

    /**
     * 结算方式
     */
    @TableField("PAY_TYPE")
    private String payType;

    /**
     * 线上流水号
     */
    @TableField("PAY_SERIAL")
    private String paySerial;

    /**
     * 备注
     */
    @TableField("PAY_DESC")
    private String payDesc;

    /**
     * 产品编号
     */
    @TableField("PRO_ID")
    private String proId;

    /**
     * 产品名称
     */
    @TableField("PRO_NAME")
    private String proName;

    /**
     * 产品到期时间
     */
    @TableField("PRO_EXDATE")
    private Date proExdate;

    /**
     * 产品操作类型
     */
    @TableField("PRO_OP_TYPE")
    private String proOpType;

    /**
     * 产品使用年限
     */
    @TableField("PRO_AGE")
    private Double proAge;

    /**
     * 是否开发票，1为需要
     */
    @TableField("NEED_BILL")
    private Double needBill;

    /**
     * 是否解冻，1已解冻
     */
    @TableField("NEED_UNFREEZE")
    private Double needUnfreeze;

    /**
     * 是否加入业绩，1为加业绩，-1为减业绩
     */
    @TableField("NEED_ACH")
    private Double needAch;

    @TableField("PROMOTE_ID")
    private String promoteId;

    @TableField("PROMOTE_NAME")
    private String promoteName;

    @TableField("TIP")
    private String tip;


}
