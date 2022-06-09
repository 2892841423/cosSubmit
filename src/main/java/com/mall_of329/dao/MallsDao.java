package com.mall_of329.dao;

import com.mall_of329.entity.Malls;
import com.mall_of329.entity.Products;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Malls)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-05 22:11:16
 */
public interface MallsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Malls queryById(String id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Malls> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param malls 实例对象
     * @return 对象列表
     */
    List<Malls> queryAll(Malls malls);

    /**
     * 新增数据
     *
     * @param malls 实例对象
     * @return 影响行数
     */
    int insert(Malls malls);

    /**
     * 修改数据
     *
     * @param malls 实例对象
     * @return 影响行数
     */
    int update(Malls malls);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);
    /**
     * 通过商铺id查询商品
     *
     * @param id 主键
     * @return 商铺
     */
    List<Products> queryProductsById(String id);

}