package com.mall_of329.controller;

import com.alibaba.fastjson.JSONObject;
import com.mall_of329.base.BaseResponse;
import com.mall_of329.base.ResultUtils;
import com.mall_of329.entity.Malls;
import com.mall_of329.entity.User;
import com.mall_of329.service.MallsService;
import com.mall_of329.service.UserService;
import com.mall_of329.service.impl.UserServiceImpl;
import com.mall_of329.util.TencentCosManager;
import com.mall_of329.util.mailSend;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import java.util.ArrayList;
import java.util.List;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2022-06-05 22:41:36
 */
@RestController
@RequestMapping("/user")
@CrossOrigin(origins = {"http://localhost:8081"})
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService UserService;

    }

