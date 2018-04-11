package com.monkey.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: springbasic
 * @description: 基础实体类
 * @author: monkey
 * @create: 2018-03-22 22:27
 **/
public class BaseEntity implements Serializable{

    private String id;

    private Date createTime;

    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
