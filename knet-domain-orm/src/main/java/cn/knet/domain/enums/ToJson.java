/**
 * ToJson.java
 * cn.knet.keyword.orm.local.enums
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   v1.0	 2014-5-27 		zzjin
 *
 * Copyright (c) 2014, 北龙中网(北京)科技有限责任公司 All Rights Reserved.
*/

package cn.knet.domain.enums;

import com.fasterxml.jackson.annotation.JacksonAnnotation;

import java.lang.annotation.*;

/**
 * <b>ClassName:</b> ToJson <br>
 * <b>Reason:</b><br>
 * @version 1.0
 * @Date 2014-5-27 下午5:08:33
 * @since 1.0
 */

@Documented
@Target(value = ElementType.FIELD)
@Retention(value = RetentionPolicy.RUNTIME)
@JacksonAnnotation
public @interface ToJson {
}

