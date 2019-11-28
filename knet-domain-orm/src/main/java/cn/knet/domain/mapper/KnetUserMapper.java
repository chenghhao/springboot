package cn.knet.domain.mapper;

import cn.knet.domain.entity.KnetOfficialNews;
import cn.knet.domain.entity.KnetUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xuxiannian
 * @since 2019-07-24
 */
public interface KnetUserMapper extends BaseMapper<KnetUser> {

    @Select("SELECT pe.PERM FROM KNET_PERMISSION pe,KNET_ROLES_PERMISSION rp,KNET_ROLES r,KNET_USER_ROLES ur WHERE pe.ID AND rp.R_ID = r.ID AND ur.R_ID = r.ID AND ur.USER_ID = #{userId,jdbcType=VARCHAR}")
    List<String> selectPermByUserId(@Param("userId") String userId);

}
