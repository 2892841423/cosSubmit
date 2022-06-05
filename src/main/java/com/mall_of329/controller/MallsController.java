package com.mall_of329.controller;

import com.mall_of329.entity.Malls;
import com.mall_of329.service.MallsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Malls)表控制层
 *
 * @author makejava
 * @since 2022-06-05 22:11:18
 */
@RestController
@RequestMapping("malls")
public class MallsController {
    /**
     * 服务对象
     */
    @Resource
    private MallsService mallsService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Malls selectOne(String id) {
        return this.mallsService.queryById(id);
    }

}