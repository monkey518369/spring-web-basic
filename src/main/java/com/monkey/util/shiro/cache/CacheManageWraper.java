package com.monkey.util.shiro.cache;

import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

/**
 * @program: springbasic
 * @description: 封装shiro的cachemanager
 * @author: monkey
 * @create: 2018-03-27 17:49
 **/
public class CacheManageWraper implements CacheManager {

    private static Logger logger = LoggerFactory.getLogger(CacheManageWraper.class.getName());

    private org.springframework.cache.CacheManager cacheManager;
    @Override
    public <K, V> org.apache.shiro.cache.Cache<K, V> getCache(String s) throws CacheException {
        logger.info("cacheName:"+s);
        return new SpringCache<>(cacheManager.getCache(s));
    }


    public void setCacheManager(org.springframework.cache.CacheManager cacheManager){
        this.cacheManager = cacheManager;
    }



    public static final class SpringCache<K,V> implements org.apache.shiro.cache.Cache<K,V>{

        private Cache cache;

        public SpringCache(Cache cache){
            this.cache = cache;
        }

        @Override
        public V get(K k) throws CacheException {
            logger.info("cache:"+cache);
            logger.info("cache get:"+k);
            Cache.ValueWrapper wrapper = cache.get(k);
            Object obj = wrapper!=null?wrapper.get():null;
            if(null != obj){
                try{
                    return (V)obj;
                }catch (Exception e){
                    logger.error(e.toString(),e);
                }
            }
            return null;
        }

        @Override
        public V put(K k, V v) throws CacheException {
            Cache.ValueWrapper value = cache.get(k);
            cache.put(k,v);
            return (value != null ? ((V)value.get()) : null);
        }

        @Override
        public V remove(K k) throws CacheException {
            Cache.ValueWrapper value = cache.get(k);
            cache.evict(k);
            return value!=null?(V)value.get():null;
        }

        @Override
        public void clear() throws CacheException {
            cache.clear();
        }

        @Override
        public int size() {
            return 0;
        }

        @Override
        public Set<K> keys() {
            return Collections.emptySet();
        }

        @Override
        public Collection<V> values() {
            return Collections.emptySet();
        }
    }
}
