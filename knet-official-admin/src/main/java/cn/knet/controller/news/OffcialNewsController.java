package cn.knet.controller.news;

import cn.knet.domain.entity.KnetOfficialGroup;
import cn.knet.domain.entity.KnetOfficialGroupInte;
import cn.knet.domain.entity.KnetOfficialNews;
import cn.knet.domain.mapper.KnetOfficialGroupInteMapper;
import cn.knet.domain.mapper.KnetOfficialGroupMapper;
import cn.knet.domain.mapper.KnetOfficialNewsMapper;
import cn.knet.service.OffcialNewsService;
import cn.knet.vo.LigerBean;
import cn.knet.vo.ResultBean;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author dcx
 * @create 2019-11-26 9:13
 */
@Controller
@RequestMapping("/news")
public class OffcialNewsController {

    @Autowired
    private OffcialNewsService offcialNewsService;
    @Autowired
    private KnetOfficialGroupMapper knetOfficialGroupMapper;
    @Autowired
    private KnetOfficialGroupInteMapper knetOfficialGroupInteMapper;
    @Autowired
    KnetOfficialNewsMapper newsMapper;

    @RequestMapping(value = "/index")
    public String index(Model model) {
        //查询分组
        List<KnetOfficialGroup> list = knetOfficialGroupMapper.selectList(new QueryWrapper<KnetOfficialGroup>());
        model.addAttribute("gr", list);
        return "news/index";
    }

    @RequestMapping(value = "/list")
    @ResponseBody
    public LigerBean list(int page, int pageSize, String title, String group, String status, String fromDate, String toDate, Model model) {
        return offcialNewsService.getList(title, group, fromDate, toDate, status, page, pageSize);
    }

    @RequestMapping(value = "/groupAdd")
    @ResponseBody
    public ResultBean groupAdd(String groupName) {
        ResultBean bean = offcialNewsService.groupAdd(groupName);
        return null;
    }

    @RequestMapping(value = "/updateNewsGroup")
    @ResponseBody
    public ResultBean updateNewsGroup(String newsId, String groupId) {
        ResultBean bean = offcialNewsService.updateNewsGroup(newsId, groupId);
        return null;
    }

    @RequestMapping(value = "/recallnews")
    @ResponseBody
    public boolean recallnews(String newsId) {
        return offcialNewsService.recallnews(newsId);
    }

    @RequestMapping(value = "/deletenews")
    @ResponseBody
    public boolean deletenews(String newsId) {
        return offcialNewsService.deletenews(newsId);
    }


    @RequestMapping(value = "/toedit")
    public String toedit(String newsId, Model model) {
        List<KnetOfficialGroup> list = knetOfficialGroupMapper.selectList(null);
        model.addAttribute("gr", list);
        if (StringUtils.isNotBlank(newsId)) {
            KnetOfficialNews news = offcialNewsService.getNews(newsId);
            model.addAttribute("news", news);
            List<KnetOfficialGroupInte> glist = knetOfficialGroupInteMapper.selectList(new QueryWrapper<KnetOfficialGroupInte>().eq("NEWS_ID", newsId));
            model.addAttribute("glist", glist);
        }
        return "news/newsedit";
    }

    @RequestMapping(value = "/toAdd")
    public String toAdd(Model model) {
        //查询分组
        List<KnetOfficialGroup> list = knetOfficialGroupMapper.selectList(null);
        model.addAttribute("gr", list);
        return "news/newsedit";
    }

    @RequestMapping(value = "/save")
    @ResponseBody
    public ResultBean save(KnetOfficialNews news, String group) {
        return offcialNewsService.save(news, group);
    }
}