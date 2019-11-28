package cn.knet.service;

/**
 * @author dcx
 * @create 2019-11-26 9:13
 */


import cn.knet.domain.entity.KnetOfficialBanner;
import cn.knet.domain.entity.KnetOfficialGroup;
import cn.knet.domain.entity.KnetOfficialGroupInte;
import cn.knet.domain.entity.KnetOfficialNews;
import cn.knet.domain.mapper.KnetOfficialBannerMapper;
import cn.knet.domain.mapper.KnetOfficialGroupInteMapper;
import cn.knet.domain.mapper.KnetOfficialGroupMapper;
import cn.knet.domain.mapper.KnetOfficialNewsMapper;
import cn.knet.domain.utils.DateUtil;
import cn.knet.domain.utils.UUIDGenerator;
import cn.knet.utils.DateUtils;
import cn.knet.vo.KnetOffcialNewsGroupVo;
import cn.knet.vo.LigerBean;
import cn.knet.vo.ResultBean;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OffcialNewsService {

    @Autowired
    private KnetOfficialNewsMapper knetOfficialNewsMapper;
    @Autowired
    private KnetOfficialGroupMapper knetOfficialGroupMapper;
    @Autowired
    private KnetOfficialGroupInteMapper knetOfficialGroupInteMapper;
    @Autowired
    private KnetOfficialBannerMapper knetOfficialBannerMapper;

    public LigerBean getList(String title, String group, String fromDate, String toDate, String status, int page, int pageSize) {
        QueryWrapper queryWrapper = new QueryWrapper<KnetOfficialNews>();
        if (StringUtils.isNotBlank(group)) {
            queryWrapper.apply("exists (select * from knet_official_group_inte inte where inte.group_id={0})",  group);
        }
        if (StringUtils.isNotBlank(fromDate) ) {
            queryWrapper.apply("to_char(CREATE_DATE, 'yyyy-MM-dd')>={0}", DateUtils.formatDate(DateUtils.getDate(fromDate),"yyyy-MM-dd"));
        }
        if (StringUtils.isNotBlank(toDate)) {
            queryWrapper.apply("to_char(CREATE_DATE, 'yyyy-MM-dd')<={0}",  DateUtils.formatDate(DateUtils.getDate(toDate),"yyyy-MM-dd"));
        }
        if (StringUtils.isNotBlank(title)) {
            queryWrapper.like("TITLE", title);
        }
        if (StringUtils.isNotBlank(status)) {
            queryWrapper.eq("STATUS", status);
        }
        queryWrapper.orderByDesc("CREATE_DATE");
        IPage<KnetOfficialNews> iPage = knetOfficialNewsMapper.selectPage(new Page<>(page, pageSize), queryWrapper);
        return new LigerBean((int) iPage.getTotal(), iPage.getRecords());
    }

    public List<KnetOfficialNews> getAllList() {
        return knetOfficialNewsMapper.selectList(new QueryWrapper<KnetOfficialNews>());
    }

    public ResultBean groupAdd(String groupName) {
        ResultBean bean = new ResultBean();
        if (StringUtils.isNotBlank(groupName)) {
            KnetOfficialGroup g = new KnetOfficialGroup();
            g.setId(UUIDGenerator.getUUID());
            g.setGroupName(groupName);
            knetOfficialGroupMapper.insert(g);
            bean.setFlag(true);
            bean.setMsg("成功");
            return bean;
        }
        bean.setMsg("失败!");
        return bean;
    }

    /**
     * 改变网址分类
     */
    public ResultBean updateNewsGroup(String newsId, String groupId) {
        ResultBean bean = new ResultBean();
        if (StringUtils.isNotBlank(groupId) && StringUtils.isNotBlank(newsId)) {
            KnetOfficialGroupInte in = new KnetOfficialGroupInte();
            in.setId(UUIDGenerator.getUUID());
            in.setNewsId(newsId);
            in.setGroupId(groupId);
            knetOfficialGroupInteMapper.insert(in);
            bean.setFlag(true);
            return bean;
        }
        return bean;
    }

    public KnetOfficialNews getNews(String newsId) {
        return knetOfficialNewsMapper.selectById(newsId);
    }

    @Transactional
    public ResultBean save(KnetOfficialNews news, String group) {
        ResultBean bean = new ResultBean();
        if (StringUtils.isNotBlank(news.getId())) {
            KnetOfficialNews news2 = knetOfficialNewsMapper.selectById(news.getId());
            news.setStatus("N");
            news.setReadingVolume(news2.getReadingVolume());
            news.setUpdateDate(new Date());
            if(news.getCreateDate()==null){
                news.setCreateDate(news2.getCreateDate());
            }
            //暴力的干掉所有分组,然后再增加
            List<KnetOfficialGroupInte> list = knetOfficialGroupInteMapper.selectList(new QueryWrapper<KnetOfficialGroupInte>().eq("NEWS_ID", news.getId()));
            if (list != null && list.size() > 0) {
                List<String> ids = new ArrayList<>();
                for (KnetOfficialGroupInte inte : list) {
                    ids.add(inte.getNewsId());
                }
                knetOfficialGroupInteMapper.deleteBatchIds(ids);
            }
            if (StringUtils.isNotBlank(group)) {
                String[] split = group.split(",");
                for (int i = 0; i < split.length; i++) {
                    KnetOfficialGroupInte record = new KnetOfficialGroupInte();
                    record.setGroupId(split[i]);
                    record.setId(UUIDGenerator.getUUID());
                    record.setNewsId(news.getId());
                    knetOfficialGroupInteMapper.insert(record);
                }
            }
            int i = knetOfficialNewsMapper.updateById(news);
            if (i > 0) {
                bean.setFlag(true);
            }
        } else {
            news.setStatus("N");
            if(news.getCreateDate()==null){
                news.setCreateDate(new Date());
            }
            news.setReadingVolume(new Double(0));
            news.setId(UUIDGenerator.getUUID());
            knetOfficialNewsMapper.insert(news);
            String[] split = group.split(",");
            if (split != null && split.length > 0) {
                for (int i = 0; i < split.length; i++) {
                    KnetOfficialGroupInte record = new KnetOfficialGroupInte();
                    record.setGroupId(split[i]);
                    record.setId(UUIDGenerator.getUUID());
                    record.setNewsId(news.getId());
                    knetOfficialGroupInteMapper.insert(record);
                }
            }
            bean.setFlag(true);
        }
        return bean;
    }

    public boolean recallnews(String newsId) {
        KnetOfficialNews news = knetOfficialNewsMapper.selectById(newsId);
        String status = news.getStatus();
        news.setStatus(status.equals("Y") ? "N" : "Y");
        int i = knetOfficialNewsMapper.updateById(news);
        if (i > 0) {
            return true;
        }
        return false;
    }

    public boolean deletenews(String newsId) {
        int i = knetOfficialNewsMapper.deleteById(newsId);
        if (i > 0) {
            return true;
        }
        return false;
    }


    /**
     * 查询
     *
     * @return
     */
    public LigerBean getGroupList() {
        List<KnetOfficialGroup> list = knetOfficialGroupMapper.selectList(null);
        List<KnetOffcialNewsGroupVo> volist = new ArrayList<KnetOffcialNewsGroupVo>();

        if (list != null && list.size() > 0) {
            for (KnetOfficialGroup group : list) {
                KnetOffcialNewsGroupVo vo = new KnetOffcialNewsGroupVo();
                QueryWrapper<KnetOfficialGroupInte> queryWrapper = new QueryWrapper();
                queryWrapper.eq("GROUP_ID", group.getId());
                List<KnetOfficialGroupInte> glist = knetOfficialGroupInteMapper.selectList(queryWrapper);
                vo.setGroupName(group.getGroupName());
                vo.setId(group.getId());
                vo.setNewstotal(glist.size());
                volist.add(vo);
            }
        }
        //查询所有未分类的域名
        List<KnetOfficialGroupInte> inteList = knetOfficialGroupInteMapper.selectList(null);
        List<String> l = new ArrayList<String>();
        for (KnetOfficialGroupInte inte : inteList) {
            l.add(inte.getNewsId());
        }
        List<KnetOfficialNews> otherList = knetOfficialNewsMapper.selectList(new QueryWrapper<KnetOfficialNews>().ne("ID", "1").eq("STATUS", "Y"));

        return new LigerBean(otherList.size(), volist);
    }

    public boolean addgroup(String groupName) {
        if (StringUtils.isNotBlank(groupName)) {
            KnetOfficialGroup group = new KnetOfficialGroup();
            group.setGroupName(groupName);
            group.setId(UUIDGenerator.getUUID());
            int i = knetOfficialGroupMapper.insert(group);
            if (i > 0) {
                return true;
            }
        }
        return false;
    }

    public boolean editgroup(KnetOfficialGroup group) {
        if (group.getId() != null) {
            KnetOfficialGroup key = knetOfficialGroupMapper.selectById(group.getId());
            key.setGroupName(group.getGroupName());
            int i = knetOfficialGroupMapper.updateById(key);
            if (i > 0) {
                return true;
            }
        }
        return false;
    }

    @Transactional
    public boolean deletegroup(KnetOfficialGroup group) {
        //需要删除所有处于该组的分类新闻
        if (group.getId() != null) {
            List<KnetOfficialGroupInte> list = knetOfficialGroupInteMapper.selectList(new QueryWrapper<KnetOfficialGroupInte>().eq("GROUP_ID", group.getId()));
            if (list != null && list.size() > 0) {
                List<String> ids = new ArrayList<>();
                for (KnetOfficialGroupInte inte : list) {
                    ids.add(inte.getId());
                }
                knetOfficialGroupInteMapper.deleteBatchIds(ids);
            }
            knetOfficialGroupMapper.deleteById(group.getId());
            return true;
        }
        return false;
    }


    /**
     * 获取banner列表
     *
     * @param status
     * @return
     */
    public LigerBean getBannerList(String status) {
        QueryWrapper<KnetOfficialBanner> queryWrapper = new QueryWrapper();
        if (StringUtils.isNotBlank(status)) {
            queryWrapper.eq("STATUS", status);
        }
        queryWrapper.orderByAsc("SORT");
        IPage iPage = knetOfficialBannerMapper.selectPage(new Page<>(), queryWrapper);
        return new LigerBean((int) iPage.getTotal(),
                iPage.getRecords());
    }


    /**
     * banner下线
     */

    public boolean setStatus(String id, String status) {

        if (StringUtils.isNotBlank(id) && StringUtils.isNotBlank(status)) {
            KnetOfficialBanner banner = knetOfficialBannerMapper.selectById(id);
            if (banner != null) {
                banner.setStatus(status);
                int i = knetOfficialBannerMapper.updateById(banner);
                if (i > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 新建banner/编辑banner
     *
     * @param banner
     * @return
     */
    public boolean addBanner(KnetOfficialBanner banner) {
        if (StringUtils.isNotBlank(banner.getId())) {
            KnetOfficialBanner ob = knetOfficialBannerMapper.selectById(banner.getId());
            ob.setImage(banner.getImage());
            ob.setUrl(banner.getUrl());
            ob.setStatus("N");
            int i = knetOfficialBannerMapper.updateById(ob);
            if (i > 0) {
                return true;
            }
        } else {
            banner.setId(UUIDGenerator.getUUID());
            banner.setStatus("N");
            banner.setCreateDate(new Date());
            int i = knetOfficialBannerMapper.insert(banner);
            if (i > 0) {
                return true;
            }
        }

        return false;
    }


    /**
     * 删除banner
     *
     * @param banner
     * @return
     */
    public boolean deleteBanner(KnetOfficialBanner banner) {
        if (StringUtils.isNotBlank(banner.getId())) {
            int i = knetOfficialBannerMapper.deleteById(banner.getId());
            if (i > 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * 编辑排序
     */
    @Transactional
    public boolean setSort(String id, Integer newsort) {
        if (StringUtils.isNotBlank(id) && newsort != null) {
            KnetOfficialBanner banner = knetOfficialBannerMapper.selectById(id);
            if (banner != null) {
                //顺序的交换 一次排序  取决于挪动的banner和目标banner 的关系
                //1 目标banner位置大于挪动的banner位置
                QueryWrapper<KnetOfficialBanner> queryWrapper = new QueryWrapper<>();
                if (newsort > banner.getSort()) {
                    queryWrapper.between("SORT", banner.getSort(), newsort);
                    queryWrapper.orderByAsc("SORT");
                    List<KnetOfficialBanner> list = knetOfficialBannerMapper.selectList(queryWrapper);
                    //从小到大
                    for (int i = 0; i < list.size(); i++) {
                        //头变尾
                        if (i == 0) {
                            list.get(0).setSort(new Double(newsort));
                            knetOfficialBannerMapper.updateById(list.get(0));
                        } else {
                            list.get(i).setSort(list.get(i).getSort() - 1);
                            knetOfficialBannerMapper.updateById(list.get(i));
                        }
                    }
                } else if (newsort < banner.getSort()) {
                    //2.小于
                    queryWrapper.between("SORT", newsort, banner.getSort());
                    queryWrapper.orderByDesc("SORT");
                    List<KnetOfficialBanner> list = knetOfficialBannerMapper.selectList(queryWrapper);
                    //从大到小
                    for (int i = 0; i < list.size(); i++) {
                        //头变尾
                        if (i == 0) {
                            list.get(0).setSort(new Double(newsort));
                            knetOfficialBannerMapper.updateById(list.get(0));
                        } else {
                            list.get(i).setSort(new Double(list.get(i).getSort() + 1));
                            knetOfficialBannerMapper.updateById(list.get(i));
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

}