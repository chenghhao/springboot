package cn.knet.domain.mapper;

import cn.knet.domain.entity.KnetOfficialNews;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author xuxiannian
 * @since 2019-07-05
 */
public interface KnetOfficialNewsMapper extends BaseMapper<KnetOfficialNews> {

    @Select("SELECT N.* FROM KNET_OFFICIAL_NEWS N LEFT JOIN KNET_OFFICIAL_GROUP_INTE G ON N.ID=G.NEWS_ID WHERE G.GROUP_ID=#{groupId} AND N.STATUS='Y' ORDER BY CREATE_DATE DESC")
    IPage<KnetOfficialNews> selectPageByGroupId(IPage<KnetOfficialNews> page, @Param("groupId") String groupId);



}
