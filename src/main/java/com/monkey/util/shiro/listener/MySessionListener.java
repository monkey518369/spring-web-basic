package com.monkey.util.shiro.listener;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @program: springbasic
 * @description: session监听器
 * @author: monkey
 * @create: 2018-03-26 22:05
 **/
public class MySessionListener implements SessionListener {


    private static final Logger log = LoggerFactory.getLogger(MySessionListener.class.getName());

    @Override
    public void onStart(Session session) {
        log.info("the session [" + session.getId() + "] is start" + session.toString());
    }

    @Override
    public void onStop(Session session) {
        log.info("the session ["+session.getId()+"] is stopping"+ session.toString());
    }

    @Override
    public void onExpiration(Session session) {
        log.info("the session [" + session.getId() + "] is expiration"+ session.toString());
    }
}
