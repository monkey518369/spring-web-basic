package com.monkey.util.cache;

import org.apache.commons.lang3.SerializationUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.Serializable;
import java.util.concurrent.Callable;

/**
 * @program: springbasic
 * @description:
 * @author: monkey
 * @create: 2018-04-02 23:56
 **/
public class RedisCache implements Cache {

    private final Logger logger = LoggerFactory.getLogger(RedisCache.class.getName());

    private long liveTime;
    private String name;
    private RedisTemplate<String,Object> template;

    public void setLiveTime(long time){
        liveTime = time;
    }

    private long getLiveTime(){
        return liveTime;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setTemplate(RedisTemplate template){
        this.template = template;
    }

    public RedisTemplate getTemplate(){
        return template;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Object getNativeCache() {
        return template;
    }

    @Override
    public ValueWrapper get(Object o) {
        String key = o.toString();
        Object obj = template.execute((RedisConnection redisConnection)->{
           byte[] value = redisConnection.get(key.getBytes());
           if(null == value){
               return null;
           }
           return SerializationUtils.serialize(value);
        });
        return (obj != null ? new SimpleValueWrapper(obj) : null);
    }

    @Override
    public <T> T get(Object o, Class<T> aClass) {
        ValueWrapper wrapper = get(o);
        try{
            Object obj = wrapper.get();
            if(null != obj){
                return (T)obj;
            }
        }catch (Exception e){
            logger.error(e.toString(),e);
        }

        return null;
    }

    @Override
    public <T> T get(Object o, Callable<T> callable) {
        return null;
    }

    @Override
    public void put(Object o, Object o1) {
        if(null == o || null == o1){
            return;
        }
        String keyStr = o.toString();
        byte[] value = SerializationUtils.serialize((Serializable) o1);
        template.execute((RedisConnection redisConnection) -> {
           redisConnection.set(keyStr.getBytes(),value);
           if(liveTime>0){
               redisConnection.expire(keyStr.getBytes(),liveTime);
           }
           return 1;
        });
    }

    @Override
    public ValueWrapper putIfAbsent(Object o, Object o1) {
        return null;
    }

    @Override
    public void evict(Object o) {
        String key = o.toString();
        template.execute((RedisConnection redisConnection) -> redisConnection.del(key.getBytes()));
    }

    @Override
    public void clear() {
        template.execute((RedisConnection redisConnection)->{
            redisConnection.flushDb();
            return "ok";
        });
    }
}
