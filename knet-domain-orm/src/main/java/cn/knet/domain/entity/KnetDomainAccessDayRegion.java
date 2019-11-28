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
@TableName("KNET_DOMAIN_ACCESS_DAY_REGION")
public class KnetDomainAccessDayRegion implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("ACCESS_DATE")
    private Date accessDate;

    @TableField("NUM")
    private long num;

    @TableField("REGION")
    private String region;


}
