package cn.knet.service;

/**
 * @author dcx
 * @create 2019-11-26 8:40
 */


import cn.knet.utils.JsonUtils;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.apache.http.entity.ContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class FileService {

    @Value(value = "${fsUrl:http://hades.om.knet.cn/}")
    protected String fsUrl;

    @Value(value = "${fsShowUrl:http://fs.knet.cn/}")
    protected String fsShowUrl;

    static final String UPLOAD_PATH = "/image/";
    private static final String CUT_PATH = "/image/cut/";

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    public String nickName(String kid, String nickName) throws Exception {
        return "0";
    }

    @SuppressWarnings("rawtypes")
    public String doUploadFile(MultipartFile file) throws Exception {
        Map<String, String> result = buildBaseLocalParams(file);
        String json = JsonUtils.toJson(result);
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<String>(json, headers);
        logger.info("=======================开始文件上传, URL=" + fsUrl + UPLOAD_PATH);
        ResponseEntity<Map> map = restTemplate.postForEntity(fsUrl
                + UPLOAD_PATH, request, Map.class);
        logger.info("=======================返回结果为:" + fsShowUrl + ((Map) map.getBody().get("data")).get("filePath"));
        if (map.getStatusCode().value() != 200) {
            logger.error(map.getBody().toString());
            return null;
        } else {
            return fsShowUrl
                    + ((Map) map.getBody().get("data")).get("filePath");
        }
    }

    @SuppressWarnings("rawtypes")
    public String doUploadFileBase64(String source, String suffix) throws Exception {
        Map<String, String> result = new HashMap<String, String>();
        result.put("suffix", StringUtils.isBlank(suffix) ? "jpg" : suffix);
        result.put("source", source);
        String json = JsonUtils.toJson(result);
        //logger.info(json);
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<String>(json, headers);
        ResponseEntity<Map> map = restTemplate.postForEntity(fsUrl
                + UPLOAD_PATH, request, Map.class);
        if (map.getStatusCode().value() != 200) {
            logger.error(map.getBody().toString());
            return null;
        } else {
            return fsShowUrl
                    + ((Map) map.getBody().get("data")).get("filePath");
        }
    }

    @SuppressWarnings("rawtypes")
    public String doCutLocalFile(MultipartFile file, String w, String h,
                                 String x, String y) throws Exception {
        Map<String, String> result = buildBaseLocalParams(file);
        result.put("width", w);
        result.put("height", h);
        result.put("x", x);
        result.put("y", y);
        String json = JsonUtils.toJson(result);
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<String>(json, headers);
        ResponseEntity<Map> map = restTemplate.postForEntity(fsUrl + CUT_PATH,
                request, Map.class);
        if (map.getStatusCode().value() != 200) {
            logger.error(map.getBody().toString());
            return null;
        } else {
            return fsShowUrl
                    + ((Map) map.getBody().get("data")).get("filePath");
        }
    }

    @SuppressWarnings("rawtypes")
    public String doCutRemoteFile(String url, String w, String h, String x,
                                  String y) throws Exception {
        Map<String, String> result = buildBaseRemoteParams(url);
        result.put("width", w);
        result.put("height", h);
        result.put("x", x);
        result.put("y", y);
        String json = JsonUtils.toJson(result);
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<String>(json, headers);
        ResponseEntity<Map> map = restTemplate.postForEntity(fsUrl + CUT_PATH,
                request, Map.class);
        if (map.getStatusCode().value() != 200) {
            logger.error(map.getBody().toString());
            return null;
        } else {
            return fsShowUrl
                    + ((Map) map.getBody().get("data")).get("filePath");
        }
    }

    private Map<String, String> buildBaseLocalParams(MultipartFile file)
            throws Exception {
        Map<String, String> result = new HashMap<String, String>();
        result.put(
                "suffix",
                file.getOriginalFilename().substring(
                        file.getOriginalFilename().lastIndexOf(".")));
        String source = Base64.encodeBase64String(file.getBytes());
        result.put("source", source);
        return result;
    }

    private static Map<String, String> buildBaseRemoteParams(String url) {
        Map<String, String> result = new HashMap<>();
        result.put("suffix", url.substring(url.lastIndexOf(".")));
        result.put("source", url);
        return result;
    }


    public static void main(String[] args) throws FileNotFoundException, IOException {

        File file = new File("/Users/xuxiannian/Downloads/01.png");
        MultipartFile mulFile = new MockMultipartFile(
                "01.png",        //文件名
                "01.png",        //originalName 相当于上传文件在客户机上的文件名
                ContentType.APPLICATION_OCTET_STREAM.toString(),    //文件类型,    //文件类型
                new FileInputStream(file)                           //文件流
        );

        System.out.println(mulFile);

    }
}