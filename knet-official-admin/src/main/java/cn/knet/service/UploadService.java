package cn.knet.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @author dcx
 * @create 2019-11-26 8:40
 */
@Service
public class UploadService {
    @Resource
    FileService fileService;

    public String upload(MultipartFile file) throws Exception {
        return fileService.doUploadFile(file);
    }

    public String uploadBase64(String img) throws Exception {
        String source = img.substring((img.indexOf(",") + 1), img.length());
        String rex = img.substring((img.indexOf("/") + 1), (img.indexOf(";")));
        return fileService.doUploadFileBase64(source, rex);
    }

}
