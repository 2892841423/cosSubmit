package com.mall_of329.service;

import com.mall_of329.entity.Products;
import java.util.List;

/**
 * (Products)表服务接口
 *
 * @author makejava
 * @since 2022-06-05 22:11:33
 */
public interface ProductsService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Products queryById(String id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Products> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param products 实例对象
     * @return 实例对象
     */
    Products insert(Products products);

    /**
     * 修改数据
     *
     * @param products 实例对象
     * @return 实例对象
     */
    Products update(Products products);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

}