package cn.knet.domain.mapper;

import cn.knet.domain.entity.KnetAgent;
import cn.knet.domain.vo.KnetAgentVo;
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
 * @since 2019-09-30
 */
public interface KnetAgentMapper extends BaseMapper<KnetAgent> {
    @Select(value = "select a.name,d.u_id,d.contact_phone from knet_agent a ,knet_agent_detail d  where a.status='OK' and a.IS_SSMS='Y' and  a.u_id=d.u_id and d.contact_phone is not null")
    public List<KnetAgentVo> selectAgent();

    @Select(value = "select  nvl(sum(decode(t.op_type,\n" +
            "                  'DRAW',\n" +
            "                  t.PRO_AGE,\n" +
            "                  'AGREEMENT_DRAW',\n" +
            "                  t.PRO_AGE,\n" +
            "                  'REFUND',\n" +
            "                  -t.PRO_AGE,\n" +
            "                  'SPECIAL_REFUND',\n" +
            "                  -t.PRO_AGE,\n" +
            "                  0)),0) as age\n" +
            "  from KNET_AGENT_FEE_DETAIL t\n" +
            " where t.agent_id=#{id} and t.op_date>=#{staDate} and t.op_date<=#{endDate}")
    int getProAge(@Param(value = "staDate") Date staDate, @Param(value = "endDate") Date endDate, @Param(value = "id") String id);
}
