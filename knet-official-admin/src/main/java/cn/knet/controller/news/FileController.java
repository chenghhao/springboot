package cn.knet.controller.news;


import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class FileController {
    Logger logger = LoggerFactory.getLogger(getClass());

    private static long MAX_FILE_LENGTH = 10 * 1024 * 1024;// 最大文件10M
    @Resource
    cn.knet.service.FileService FileService;

    @ResponseBody
    @RequestMapping(value = "/kindeditor/uploadimg.shtml", method = {RequestMethod.POST, RequestMethod.HEAD}, produces = "application/json;charset=UTF-8")
    public String upload(String localUrl, MultipartFile imgFile, HttpServletRequest request,
                         HttpServletResponse response) throws Exception {
        JSONObject obj = new JSONObject();
        try {
            if (imgFile == null) {
                obj.put("error", 1);
                obj.put("message", "上传文件为空");
                response.getWriter().write(obj.toString());
                return null;
            }

            String fileName = imgFile.getOriginalFilename();


            if (fileName.lastIndexOf(".") == -1) {
                obj.put("error", 1);
                obj.put("message", "当前文件格式不允许上传");
                response.getWriter().write(obj.toString());
                return null;
            }


            if (imgFile.getSize() > MAX_FILE_LENGTH) {
                obj.put("error", 1);
                obj.put("message", "文件大小超过10M");
                response.getWriter().write(obj.toString());
                return null;
            }

            obj.put("error", 0);
            obj.put("url", FileService.doUploadFile(imgFile));

        } catch (Exception e) {
            obj.put("error", 1);
            obj.put("message", "文件上传失败");
            logger.error("文件上传失败", e);
        }

        response.getWriter().write(obj.toString());
        return null;
    }
}
