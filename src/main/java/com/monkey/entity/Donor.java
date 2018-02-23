package com.monkey.entity;

import org.apache.ibatis.type.Alias;

@Alias("Donor")
public class Donor {

    private String id;

    private int count;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "id:"+id+"===count:"+count;
    }
}
