package cn.knet.domain.mapper;

import cn.knet.domain.entity.KnetDomainAccessDayRegion;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xuxiannian
 * @since 2019-08-19
 */
public interface KnetDomainAccessDayRegionMapper extends BaseMapper<KnetDomainAccessDayRegion> {

    @Select("SELECT t.region, sum(t.num) num from KNET_DOMAIN_ACCESS_DAY_REGION t where t.access_date between to_date(#{fromDate},'yyyy-MM-dd')  and to_date(#{toDate},'yyyy-MM-dd') group by t.region order by num desc")
    List<KnetDomainAccessDayRegion> selectNums(@Param("fromDate") String fromDate, @Param("toDate") String toDate );
}
