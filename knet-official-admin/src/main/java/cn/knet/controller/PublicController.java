package cn.knet.controller;

import cn.knet.domain.entity.KnetUser;
import cn.knet.domain.mapper.KnetUserMapper;
import cn.knet.service.UploadService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 代理商申请资格、登录
 *
 * @author zhangning
 */
@Controller
public class PublicController extends SuperController {
    @Resource
    UploadService uploadService;
    @Resource
    KnetUserMapper knetUserMapper;

    /**
     * 跳转到登录页面
     */
    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String login(HttpServletRequest request, Model model) {

        return "login";
    }

    @RequestMapping(value = "/unauth", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String unauthorized(HttpServletRequest request, Model model) {

        return "unauth";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> login(Model model, HttpServletRequest request, String username, String password,
                                     RedirectAttributes redirectAttributes) throws Exception {
        Map<String, String> r = new HashMap<String, String>();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            subject.getSession().setAttribute("user", subject.getPrincipal());
            r.put("code", "0");
        } catch (Exception ae) {
            if (ae instanceof AuthenticationException) {
                r.put("code", "1");
                r.put("msg", ae.getMessage());
                ae.printStackTrace();
            } else {
                r.put("code", "2");
                r.put("msg", "未知错误，请联系管理员");
                ae.printStackTrace();
            }
        }
        return r;
    }

    @RequestMapping(value = "/logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            subject.getSession().setAttribute("user",null);
            subject.logout(); // session 会销毁，在SessionListener监听session销毁，清理权限缓存
        }
        return "redirect:/";
    }

    /**
     * 跳转到index页面
     */
    @RequestMapping(value = {"/index.shtml", "/"}, method = {RequestMethod.GET, RequestMethod.HEAD})
    public String index(HttpServletRequest request, Model model) {
        KnetUser userAccount = getCurrentLoginUser(request);
        if (userAccount == null) {
            return "login";
        }
        model.addAttribute("userAccount", userAccount);
        return "start";
    }

    /**
     * 跳转到欢迎页面
     */
    @RequestMapping(value = "/welcome.shtml", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String welcome(HttpServletRequest request, Model model) {
        KnetUser userAccount = getCurrentLoginUser(request);
        if (userAccount == null) {
            return "login";
        }
        return "welcome";
    }

    @RequestMapping(value = "/upload", method = {RequestMethod.POST, RequestMethod.HEAD})
    @ResponseBody
    public Map<String, String> upload(MultipartFile file) throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        map.put("url", uploadService.upload(file));
        map.put("name", file.getOriginalFilename());
        return map;
    }

    @RequestMapping(value = "/my/{type}", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String upload(@PathVariable String type) {
        return type;
    }

    @RequestMapping(value = "/my/changePassword", method = {RequestMethod.POST, RequestMethod.HEAD})
    @ResponseBody
    public String setMy(String newPassword, String oldPassword, HttpServletRequest request) {
        String id = super.getCurrentLoginUser(request).getId();
        KnetUser knetUser = knetUserMapper.selectById(id);
        if (knetUser.getPassword().equals(DigestUtils.md5Hex(oldPassword))) {
            knetUser.setPassword(DigestUtils.md5Hex(newPassword));
            knetUserMapper.updateById(knetUser);
            return "0";
        } else {
            return "-1";
        }
    }

}
