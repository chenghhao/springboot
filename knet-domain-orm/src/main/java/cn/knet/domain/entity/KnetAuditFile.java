package cn.knet.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 注册人审核资料
 * </p>
 *
 * @author xuxiannian
 * @since 2019-07-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("KNET_AUDIT_FILE")
public class KnetAuditFile implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("DOMAIN_REGISTRANT_ID")
    private String domainRegistrantId;

    @TableField("AUDIT_FILE")
    private String auditFile;

    @TableField("OTHER_FILE1")
    private String otherFile1;

    @TableField("OTHER_FILE2")
    private String otherFile2;

    @TableField("OTHER_FILE3")
    private String otherFile3;

    @TableField("OTHER_FILE4")
    private String otherFile4;


}
