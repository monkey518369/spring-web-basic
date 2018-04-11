package com.monkey.service;

import com.monkey.repository.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @program: springbasic
 * @description: 基础
 * @author: monkey
 * @create: 2018-03-22 22:42
 **/
public class BaseServiceImpl<T> implements BaseService<T> {

    @Autowired
    BaseDao<T> baseDao;

    @Override
    public void insert(T t) {
        baseDao.insert(t);
    }

    @Override
    public T getOne(String id) {
        return baseDao.getOne(id);
    }

    @Override
    public void update(T t) {
        baseDao.update(t);
    }

    @Override
    public void delete(T t) {
        baseDao.delete(t);
    }

    @Override
    public List<T> findByPage(T t) {
        return baseDao.findByPage(t);
    }
}
