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
 * @since 2019-08-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("KNET_DOMAIN_ACCESS_DAY")
public class KnetDomainAccessDay implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("ACCESS_DATE")
    private Date accessDate;

    @TableField("NUM")
    private long num;

    @TableField("DOMAIN")
    private String domain;

    @TableField("CONTACT_NAME")
    private String contactName;


}
