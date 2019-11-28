package cn.knet.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
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
 * @since 2019-08-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("KNET_DOMAIN_ACCESS_TOTAL")
public class KnetDomainAccessTotal implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("ID")
    private String id;

    @TableField("NUM")
    private long num;

    @TableField("UPDATE_DATE")
    private Date updateDate;


}
