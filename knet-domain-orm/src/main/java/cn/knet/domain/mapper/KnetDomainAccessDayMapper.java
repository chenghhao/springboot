package cn.knet.domain.mapper;

import cn.knet.domain.entity.KnetDomainAccessDay;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xuxiannian
 * @since 2019-08-23
 */
public interface KnetDomainAccessDayMapper extends BaseMapper<KnetDomainAccessDay> {

    //@Select("select * from (select rownum as rn, vo.* from ( select T.DOMAIN, SUM(T.NUM) NUM from KNET_DOMAIN_ACCESS_DAY t GROUP BY T.DOMAIN ORDER BY NUM DESC) vo where rownum <= #{nums}) ao where ao.rn >= 1")
    @Select("select *\n" +
            "  from (select rownum as rn, vo.*\n" +
            "          from (select t.domain, sum(t.num) NUM\n" +
            "                  from KNET_DOMAIN_ACCESS_DAY t\n" +
            "                 where t.domain in\n" +
            "                       (select h.domain_name\n" +
            "                          from knet_dns_host h\n" +
            "                         where h.domain_name in\n" +
            "                               (select a.domain from KNET_DOMAIN_ACCESS_DAY a))\n" +
            "                 GROUP BY t.domain\n" +
            "                 order by NUM desc) vo\n" +
            "         where rownum <= 50) ao\n" +
            " where ao.rn >= 1\n")
    List<KnetDomainAccessDay> selectByTopNum(int nums);

}
