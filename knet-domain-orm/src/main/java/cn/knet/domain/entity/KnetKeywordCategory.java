package cn.knet.domain.entity;

import cn.knet.domain.enums.CategoryEnum;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 词性表
 * </p>
 *
 * @author xuxiannian
 * @since 2019-11-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("KNET_KEYWORD_CATEGORY")
public class KnetKeywordCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 关键词
     */
    @TableId("KEYWORD")
    private String keyword;

    @TableField("CATEGORY")
    private CategoryEnum category;

    /**
     * 创建时间
     */
    @TableField("CREATE_DATE")
    private Date createDate;

    /**
     * 修改时间
     */
    @TableField("UPDATE_DATE")
    private Date updateDate;

    /**
     * 代表字
     */
    @TableField("REPRESENT_WORD")
    private String representWord;


}
