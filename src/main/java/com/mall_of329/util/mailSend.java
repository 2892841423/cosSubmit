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

    public void sendAttachmentsMail(String to, String subject, String content, File file,String fileName) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper;
        try {
            messageHelper = new MimeMessageHelper(message,true);
            messageHelper.setFrom(from);
            messageHelper.setTo(to);
            messageHelper.setSubject(subject);
            messageHelper.setText(content,true);
            //携带附件
            messageHelper.addAttachment(fileName,file);
            javaMailSender.send(message);
//            logger.info("邮件加附件发送成功！");
        } catch (MessagingException e) {
//            logger.error("发送失败："+e);
        }
    }
}
