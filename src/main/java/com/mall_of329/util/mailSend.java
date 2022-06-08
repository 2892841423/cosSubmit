package com.mall_of329.util;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Random;

/**
 * @author huangRong
 * @date 2021/10/25 23:28
 */
@Component
@Data
@Service
public class mailSend {

    @Resource
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String from;

    /**
     * 携带附件
     */
    public void sendAttachmentsMail(String to, String subject, String content, File file, String fileName) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper;
        try {
            messageHelper = new MimeMessageHelper(message, true);
            messageHelper.setFrom(from);
            messageHelper.setTo(to);
            messageHelper.setSubject(subject);
            messageHelper.setText(content, true);
            //携带附件
            messageHelper.addAttachment(fileName, file);
            javaMailSender.send(message);
        } catch (MessagingException e) {
//            logger.error("发送失败："+e);
        }
    }


    /*
     *发送验证码
     */
    public void sendVerificationCode(String to, String Verification) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper;
        try {

            messageHelper = new MimeMessageHelper(message, true);
            messageHelper.setFrom(from);
            messageHelper.setTo(to);
            messageHelper.setText("【329Shop】 您的验证码为：" + Verification + ",有效时间为30分钟。", true);
            javaMailSender.send(message);
        } catch (MessagingException e) {
//            logger.error("发送失败："+e);
        }
    }

}
