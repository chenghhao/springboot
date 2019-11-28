package cn.knet.domain.entity;

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
 * 
 * </p>
 *
 * @author xuxiannian
 * @since 2019-07-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("KNET_OFFICIAL_NEWS")
public class KnetOfficialNews implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("ID")
    private String id;

    /**
     * 标题
     */
    @TableField("TITLE")
    private String title;

    /**
     * html新闻内容
     */
    @TableField("CONTENT")
    private String content;

    @TableField("CREATE_DATE")
    private Date createDate;

    @TableField("UPDATE_DATE")
    private Date updateDate;

    @TableField("READING_VOLUME")
    private Double readingVolume;

    /**
     * 状态Y可用 N不可用
     */
    @TableField("STATUS")
    private String status;

    /**
     * 封面
     */
    @TableField("COVER")
    private String cover;

    /**
     * 简介
     */
    @TableField("DIGEST")
    private String digest;
    /**
     * 关键字
     */
    @TableField("KEYWORD")
    private String keyword;

}
