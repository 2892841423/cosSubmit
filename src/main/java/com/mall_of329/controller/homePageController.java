package com.mall_of329.controller;

import com.alibaba.fastjson.JSONObject;
import com.mall_of329.base.BaseResponse;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author huangRong
 * @date 2022/6/8 15:02
 */
@RestController
@RequestMapping("/home")
@CrossOrigin(origins = {"http://localhost:8081"})
public class homePageController {
    @Resource
    private com.mall_of329.service.UserService UserService;

    @Resource
    private com.mall_of329.service.UserService MallsService;

    /**
     *
     * @param data
     * @return
     */
    @PostMapping("homePage")
    public BaseResponse<JSONObject> homePage(@RequestBody(required = false) JSONObject data) {

    }


}
