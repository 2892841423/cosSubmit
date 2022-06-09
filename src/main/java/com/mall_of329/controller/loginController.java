package com.mall_of329.controller;

import com.alibaba.fastjson.JSONObject;
import com.mall_of329.base.BaseResponse;
import com.mall_of329.base.ResultUtils;
import com.mall_of329.entity.User;
import com.mall_of329.service.UserService;
import com.mall_of329.util.TencentCosManager;
import com.mall_of329.util.mailSend;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.mail.MessagingException;

/**
 * @author huangRong
 * @date 2022/6/8 14:56
 */
@RestController
@RequestMapping("/login")
@CrossOrigin(origins = {"http://localhost:8081"})
public class loginController {
    /**
     * 服务对象
     */
    @Resource
    private com.mall_of329.service.UserService UserService;

    @Resource
    private mailSend emailService;

//    @Resource
//    private TencentCosManager tencentCosManager;

    @Resource
    private JavaMailSender javaMailSender;

    @Resource
    private com.mall_of329.service.MallsService MallsService;

    private int id = 0;


    /**
     * 账户密码登录
     *
     * @param data 主键
     * @return 单条数据
     */
    @PostMapping("/common")
    public BaseResponse<String> login(@RequestBody(required = false) JSONObject data) {
        Object username = data.get("username");
        Object password = data.get("password");
        User user1 = UserService.queryByMail(username.toString());
        System.out.println(user1);
        if (user1 != null) {
            if (user1.getPassword().equals(password)) {
                return ResultUtils.success("登录成功！！！");
            } else {
                return ResultUtils.error(0, "密码错误");
            }
        }
        return ResultUtils.error(2, "账户不存在");
    }

    /**
     * 验证码登录
     *
     * @param mail 主键
     * @return 单条数据
     */
    @PostMapping("/verificationLogin")
    //@RequestParam("mail") @RequestParam("verification")
    public BaseResponse<User> verificationLogin(@RequestBody(required = false) JSONObject data) {
        Object mail = data.get("mail");
        Object verification = data.get("verification");
        User user1 = UserService.queryByMail(mail.toString());
        if (user1 != null) {
            if (UserService.cacheTheVerificationCode(mail.toString()).equals(verification)) {
                return ResultUtils.success(user1);
            } else {
                return ResultUtils.error(0, "验证码错误或者失效");
            }
        }
        return ResultUtils.error(2, "账户不存在");
    }

    /**
     * 注册
     *
     * @param data 主键
     * @return 单条数据
     */
    @PostMapping("/register")
    public BaseResponse<User> registered1(@RequestBody(required = false) JSONObject data) {
        String mail = data.get("mail").toString();
        String verification = data.get("verification").toString();
        String password = data.get("password").toString();
        if (UserService.cacheTheVerificationCode(mail) == null)
            return ResultUtils.error(1, "验证码错误！！！");
        JSONObject json = new JSONObject();

        User user = UserService.queryByMail(mail);
        if (user == null) {
            User newUser = new User();
            newUser.setPassword(password);
            newUser.setMail(mail);
            newUser.setUsername(mail);
            id++;
            newUser.setId(id + "");
            newUser.setAlipay(mail);
            newUser.setCall(mail);
            newUser.setContactaddress(mail);
            UserService.insert(newUser);
            return ResultUtils.success(newUser);
        } else {
            return ResultUtils.error(1, "用户已经注册过了");
        }

    }

    /**
     * 获取验证码
     *
     * @param mail 主键
     * @return 单条数据
     */
    @PostMapping("/verification")
    public BaseResponse<String> registered(@RequestBody(required = false) JSONObject data) {
        String mail = data.get("mail").toString();
        try {
            String verification = UserService.captchaCache(mail);
            emailService.sendVerificationCode(mail, verification);
            return ResultUtils.success(verification);
        } catch (MessagingException e) {
            e.printStackTrace();
            return ResultUtils.error(0, "获取验证码失败");
        }

    }
}
