package com.mall_of329.control;

import com.mall_of329.base.ResultUtils;
import com.mall_of329.user.user;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author huangRong
 * @date 2022/6/5 15:33
 */
@Slf4j
@RestController
@CrossOrigin(origins = {"http://huangrong47.top", "https://huangrong47.top", "http://localhost:8081"})
public class loginControl {
    @Autowired
    private serverImpl server;




    /**
     * @param user
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ResultUtils login(user user) {

    }
}
