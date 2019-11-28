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
 * @since 2019-11-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("KNET_OFFICIAL_INDUSTRY")
public class KnetOfficialIndustry implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("ID")
    private String id;

    /**
     * 名称
     */
    @TableField("NAME")
    private String name;

    @TableField("ILEVEL")
    private Integer ilevel;


}
