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
 * 用户表
 * </p>
 *
 * @author xuxiannian
 * @since 2019-10-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("KNET_KEKE_USER")
public class KnetKekeUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("PID")
    private String pid;

    @TableField("CREATE_DATE")
    private Date createDate;

    @TableField("PHONE")
    private String phone;

    @TableField("FABULOUS_STATUS")
    private String fabulousStatus;

    @TableField("REMARK")
    private String remark;

}
