package com.mall_of329.service;

import com.mall_of329.entity.Malls;
import java.util.List;

/**
 * (Malls)表服务接口
 *
 * @author makejava
 * @since 2022-06-05 22:11:17
 */
public interface MallsService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Malls queryById(String id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Malls> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param malls 实例对象
     * @return 实例对象
     */
    Malls insert(Malls malls);

    /**
     * 修改数据
     *
     * @param malls 实例对象
     * @return 实例对象
     */
    Malls update(Malls malls);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);




}