package com.mall_of329.controller;

import com.mall_of329.entity.Products;
import com.mall_of329.service.ProductsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Products)表控制层
 *
 * @author makejava
 * @since 2022-06-05 22:11:33
 */
@RestController
@RequestMapping("products")
public class ProductsController {
    /**
     * 服务对象
     */
    @Resource
    private ProductsService productsService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Products selectOne(String id) {
        return this.productsService.queryById(id);
    }

}