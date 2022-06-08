package com.mall_of329.service.impl;

import com.mall_of329.entity.User;
import com.mall_of329.dao.UserDao;
import com.mall_of329.service.UserService;
import net.jodah.expiringmap.ExpirationPolicy;
import net.jodah.expiringmap.ExpiringMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2022-06-05 22:41:35
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    private final ExpiringMap<String, String> map = ExpiringMap.builder()
            .maxSize(1000000)
            .expiration(100, TimeUnit.SECONDS)
            .variableExpiration().expirationPolicy(ExpirationPolicy.CREATED).build();

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public User queryById(String id) {
        return this.userDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<User> queryAllByLimit(int offset, int limit) {
        return this.userDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User insert(User user) {
        this.userDao.insert(user);
        return user;
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User update(User user) {
        this.userDao.update(user);
        return this.queryById(user.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.userDao.deleteById(id) > 0;
    }
    /**
     * 通过邮箱查询
     *
     * @param mail 邮箱
     * @return 影响行数
     */
    @Override
    public User queryByMail(String mail) {
        return this.userDao.queryByMail(mail);
    }

    /**
     * 生成验证码并设置验证码过期时间
     */
    @Override
    public String captchaCache(String mail) {
        Random random = new Random();
        String Verification = "";
        for (int i = 0; i < 6; i++) {
            Verification += random.nextInt(10);
        }
        map.put(mail,Verification);

        return Verification;
    }

    @Override
    public String cacheTheVerificationCode(String mail) {

        System.out.println(mail);
        System.out.println(map.get(mail));
        return map.get(mail);
    }
}