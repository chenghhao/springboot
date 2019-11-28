package cn.knet.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author xuxiannian
 * @since 2019-11-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("KNET_PERMISSION")
public class KnetPermission implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("ID")
    private String id;

    @TableField("TITLE")
    private String title;

    @TableField("PERM")
    private String perm;


}
