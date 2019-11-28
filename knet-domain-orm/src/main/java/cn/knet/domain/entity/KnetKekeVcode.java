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
 * KEKE验证码
 * </p>
 *
 * @author xuxiannian
 * @since 2019-10-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("KNET_KEKE_VCODE")
public class KnetKekeVcode implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("ID")
    private String id;

    @TableId("PHONE")
    private String phone;

    @TableField("CREATE_DATE")
    private Date createDate;

    @TableField("VERCODE")
    private String vercode;


}
