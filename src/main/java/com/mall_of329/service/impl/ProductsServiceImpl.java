package com.mall_of329.service.impl;

import com.mall_of329.entity.Products;
import com.mall_of329.dao.ProductsDao;
import com.mall_of329.service.ProductsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Products)表服务实现类
 *
 * @author makejava
 * @since 2022-06-05 22:11:33
 */
@Service("productsService")
public class ProductsServiceImpl implements ProductsService {
    @Resource
    private ProductsDao productsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Products queryById(String id) {
        return this.productsDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Products> queryAllByLimit(int offset, int limit) {
        return this.productsDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param products 实例对象
     * @return 实例对象
     */
    @Override
    public Products insert(Products products) {
        this.productsDao.insert(products);
        return products;
    }

    /**
     * 修改数据
     *
     * @param products 实例对象
     * @return 实例对象
     */
    @Override
    public Products update(Products products) {
        this.productsDao.update(products);
        return this.queryById(products.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.productsDao.deleteById(id) > 0;
    }
    /**
     * 查询最后一个数据
     *
     * @return 最后一个产品
     */
    public Products queryLast(){
        return this.queryLast();
    }
}