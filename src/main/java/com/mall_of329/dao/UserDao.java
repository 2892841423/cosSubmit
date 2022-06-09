package com.mall_of329.dao;

import com.mall_of329.entity.Malls;
import com.mall_of329.entity.Orders;
import com.mall_of329.entity.User;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (User)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-05 22:41:34
 */
public interface UserDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    User queryById(String id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<User> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param user 实例对象
     * @return 对象列表
     */
    List<User> queryAll(User user);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 影响行数
     */
    int insert(User user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 影响行数
     */
    int update(User user);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);
    /**
     * 通过邮箱查询
     *
     * @param mail 邮箱
     * @return 影响行数
     */
    User queryByMail(String mail);
    /**
     * 通过id查询商铺
     *
     * @param id 用户id
     * @return 影响行数
     */
    List<Malls> queryMallsById(String id);
    /**
     * 通过id查询订单
     *
     * @param id 用户id
     * @return 订单列表
     */
    List<Orders> queryOrdersById(String id);


}