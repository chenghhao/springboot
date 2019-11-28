package cn.knet.domain.mapper;

import cn.knet.domain.entity.KnetDomainAccessHour;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xuxiannian
 * @since 2019-08-19
 */
public interface KnetDomainAccessHourMapper extends BaseMapper<KnetDomainAccessHour> {

    @Select("select * from (select rownum as rn, vo.* from ( select * from KNET_DOMAIN_ACCESS_HOUR t order by t.access_date desc) vo where rownum <= #{hours}) ao where ao.rn >= 1")
    List<KnetDomainAccessHour> selectByHours(int hours);
}
