package com.monkey.service;

import java.util.List;

/**
 * @program: springbasic
 * @description: 基础服务类
 * @author: monkey
 * @create: 2018-03-22 22:41
 **/
public interface BaseService<T> {

    void insert(T t);

    T getOne(String id);

    void update(T t);

    void delete(T t);

    List<T> findByPage(T t);

}
