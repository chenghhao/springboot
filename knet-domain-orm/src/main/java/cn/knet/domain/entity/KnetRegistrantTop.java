package cn.knet.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 网址注册上排名表
 * </p>
 *
 * @author xuxiannian
 * @since 2019-09-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("KNET_REGISTRANT_TOP")
public class KnetRegistrantTop implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("ID")
    private Double id;

    @TableField("REGISTRANT_NAME")
    private String registrantName;


}
