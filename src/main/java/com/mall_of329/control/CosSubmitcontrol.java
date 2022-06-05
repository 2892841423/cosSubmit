package com.mall_of329.control;

import com.alibaba.fastjson.JSONObject;
import com.mall_of329.base.BaseResponse;
import com.mall_of329.base.ResultUtils;
import com.mall_of329.service.TencentCosManager;
import com.mall_of329.service.ipAddress;
import com.mall_of329.util.mailSend;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * @author huangRong
 * @date 2021/10/21 12:17
 */
@Slf4j
@RestController
@CrossOrigin(origins = {"http://huangrong47.top", "https://huangrong47.top", "http://localhost:8081"})

public class CosSubmitcontrol {
    @Resource
    private TencentCosManager tencentCosManager;
    @Autowired
    private mailSend emailService;

    private final ipAddress ipAdd=new ipAddress();

//    /**
//     *
//     * @param response
//     * @return
//     */
//    @RequestMapping("/Cos")
//    @ResponseBody
//    public JSONObject Cos(HttpServletResponse response) {
//        response.setHeader("Access-Control-Allow-Origin", "*");
//        JSONObject json = new JSONObject();
//        json.put("hr", "zxx1111");
//        json.put("hrr", "zxx2222");
//        return json;
//    }

    /**
     * 上传文件到腾讯Cos
     * @param file
     * @return
     * @throws IOException
     */
    @PostMapping("/upload")
    public BaseResponse<String> uploadFile(MultipartFile file) throws IOException {
        File localFile = File.createTempFile("temp", null);
        String fileName = System.currentTimeMillis() / 1000 + "-" + file.getOriginalFilename();
        try {
            file.transferTo(localFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String resultPath = tencentCosManager.uploadFile(fileName, localFile);
        // 清理临时文件
        boolean deleteResult = localFile.delete();
        if (!deleteResult) {
            log.error("fileDelete error", localFile.getName());
        }
        System.out.println(resultPath);
        return ResultUtils.success(resultPath);
    }

    /**
     * 邮件发送
     * @param ipRequest
     * @return
     * @throws IOException
     */
    @RequestMapping("/submitMail")
    public BaseResponse<JSONObject> submitMails(HttpServletRequest ipRequest,MultipartFile file) throws IOException{
        JSONObject json = new JSONObject();
        File localFile = File.createTempFile("temp", null);
        String fileName = System.currentTimeMillis() / 1000 + "-" + file.getOriginalFilename();
        String receiver="1494805234@qq.com";
        try {
            file.transferTo(localFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            emailService.sendAttachmentsMail(receiver,file.getOriginalFilename(),"这是Java体系图",localFile,fileName);
            String ip = ipAdd.getIpAddress(ipRequest);
            String cityInfo = ipAddress.getCityInfo(ip);
            json.put("ip",ip);
            json.put("cityInfo",cityInfo);
            json.put("receiver",receiver);
        } catch (MessagingException e) {
            e.printStackTrace();
            return ResultUtils.error(-1,"邮件上传失败");
        }
        return ResultUtils.success(json);
    }

}