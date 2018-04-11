package com.monkey.util.common.spring.bean;

import com.monkey.util.exception.BaseException;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @program: springbasic
 * @description:
 * @author: monkey
 * @create: 2018-04-11 10:40
 * @Descript 获取bean的方法，1.继承ApplicationContextAware接口，保存一个ApplicationContext
 *                          2.通过ApplicationContextUtils获取ApplicationContext,但是这里需要一个ServletContext
 *                              具体ServletContext可以通过HttpServletRequest获取
 *                          3.通过ContextLoader获取applicationContext.但是这个方法在只能初始化完成之后使用
 **/
public class ApplicationContextImpl implements ApplicationContextAware{

    private static ApplicationContext applicationContext = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationContextImpl.applicationContext = applicationContext;
    }

    /**
     * 根据标识获取bean
     * @param alias
     * @param <T>
     * @return
     */
    public static<T> T getBean(String alias){
        return (T)applicationContext.getBean(alias);
    }

    /**
     * 根据类型获取bean
     * @param tClass
     * @param <T>
     * @return
     */
    public static<T> T getBean(Class<T> tClass) {
        validate();
        return (T)applicationContext.getBean(tClass);
    }

    /**
     * 根据alias和类型共同获取bean
     * @param alias
     * @param tClass
     * @param <T>
     * @return
     */
    public static<T> T getBean(String alias,Class<T> tClass){
        return applicationContext.getBean(alias,tClass);
    }

    public static void validate(){
        if(null == applicationContext){
            throw new BaseException("没有经过初始化");
        }
    }


}
