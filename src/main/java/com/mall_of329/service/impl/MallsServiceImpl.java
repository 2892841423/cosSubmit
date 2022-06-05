package com.mall_of329.service.impl;

import com.mall_of329.entity.Malls;
import com.mall_of329.dao.MallsDao;
import com.mall_of329.service.MallsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Malls)表服务实现类
 *
 * @author makejava
 * @since 2022-06-05 22:11:17
 */
@Service("mallsService")
public class MallsServiceImpl implements MallsService {
    @Resource
    private MallsDao mallsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Malls queryById(String id) {
        return this.mallsDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Malls> queryAllByLimit(int offset, int limit) {
        return this.mallsDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param malls 实例对象
     * @return 实例对象
     */
    @Override
    public Malls insert(Malls malls) {
        this.mallsDao.insert(malls);
        return malls;
    }

    /**
     * 修改数据
     *
     * @param malls 实例对象
     * @return 实例对象
     */
    @Override
    public Malls update(Malls malls) {
        this.mallsDao.update(malls);
        return this.queryById(malls.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.mallsDao.deleteById(id) > 0;
    }
}