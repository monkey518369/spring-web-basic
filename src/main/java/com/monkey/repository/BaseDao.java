package com.monkey.repository;

import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @program: springbasic
 * @description: 基础dao
 * @author: monkey
 * @create: 2018-03-22 22:24
 **/
public interface BaseDao<T> {

    void insert(T t);

    T getOne(String id);

    void update(T t);

    void delete(T t);

    List<T> findByPage(T t);
}
