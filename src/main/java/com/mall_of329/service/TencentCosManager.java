package com.mall_of329.service;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.model.PutObjectRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.File;

/**
 * 腾讯云对象存储管理类
 *
 * @author huangrong
 */
@Component
@Slf4j
public class TencentCosManager {

    /**
     * 当前环境
     */
    @Value("${spring.profiles.active:dev}")
    private String currentEnv;
    /**
     * 腾讯Cos文件上传路径
     */
    private static final String CDN_PATH = "https://huangrong-1307902019.cos.ap-shanghai.myqcloud.com/";
    /**
     * 存储路径
     */
    private final  String originPath = "prod".equals(currentEnv) ? "father/img" : "father/test/img";

    @Resource
    private COSClient cosClient;

    /**
     * 上传文件到腾讯Cos
     * @param fileName
     * @param file
     * @return 文件URL
     * @throws CosClientException
     */
    public String uploadFile(String fileName, File file) throws CosClientException {
        // 指定文件上传到 COS 上的路径
        String key = originPath + "/" + fileName;
        String bucketName = "huangrong-1307902019";//存储桶名字
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, file);//文件上传对象
        cosClient.putObject(putObjectRequest);//文件上传
        return CDN_PATH + key;
    }
}
