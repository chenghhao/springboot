package cn.knet.controller.news;

import cn.knet.domain.entity.KnetOfficialBanner;
import cn.knet.service.OffcialNewsService;
import cn.knet.vo.LigerBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/newsbanner")
public class OffcialNewBannerController {

    @Autowired
    private OffcialNewsService offcialNewsService;

    @RequestMapping(value = "/index")
    public String index(Model model) {
        return "newsbanner/index";
    }

    @RequestMapping(value = "/list")
    @ResponseBody
    public LigerBean list(String status) {
        return offcialNewsService.getBannerList(status);
    }

    @RequestMapping(value = "/setStatus")
    @ResponseBody
    public boolean setStatus(String id, String status) {
        return offcialNewsService.setStatus(id, status);
    }

    @RequestMapping(value = "/addBanner")
    @ResponseBody
    public boolean addBanner(KnetOfficialBanner banner) {
        return offcialNewsService.addBanner(banner);
    }

    @RequestMapping(value = "/deleteBanner")
    @ResponseBody
    public boolean deleteBanner(KnetOfficialBanner banner) {
        return offcialNewsService.deleteBanner(banner);
    }

    @RequestMapping(value = "/setSort")
    @ResponseBody
    public boolean setSort(String id, Integer newsort) {
        return offcialNewsService.setSort(id, newsort);
    }
}
