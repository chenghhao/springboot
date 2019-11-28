package cn.knet.controller.news;


import cn.knet.domain.entity.KnetOfficialGroup;
import cn.knet.service.OffcialNewsService;
import cn.knet.vo.LigerBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/newsgroup")
public class OffcialNewGroupController {

    @Autowired
    private OffcialNewsService offcialNewsService;

    @RequestMapping(value = "/index")
    public String index(Model model) {
        return "newsgroup/index";
    }

    @RequestMapping(value = "/list")
    @ResponseBody
    public LigerBean list() {
        return offcialNewsService.getGroupList();
    }

    @RequestMapping(value = "/addgroup")
    @ResponseBody
    public boolean addgroup(String groupName) {
        return offcialNewsService.addgroup(groupName);
    }

    @RequestMapping(value = "/editgroup")
    @ResponseBody
    public boolean editgroup(KnetOfficialGroup group) {
        return offcialNewsService.editgroup(group);
    }

    @RequestMapping(value = "/deletegroup")
    @ResponseBody
    public boolean deletegroup(KnetOfficialGroup group) {
        return offcialNewsService.deletegroup(group);
    }


}
