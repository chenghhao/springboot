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
 * 
 * </p>
 *
 * @author xuxiannian
 * @since 2019-11-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("KNET_OFFICIAL_GROUP")
public class KnetOfficialGroup implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("ID")
    private String id;

    /**
     * 分组名
     */
    @TableField("GROUP_NAME")
    private String groupName;


}
