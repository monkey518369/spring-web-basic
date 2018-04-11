package com.monkey.util.exception;


/**
 * @program: springbasic
 * @description:
 * @author: monkey
 * @create: 2018-04-11 11:07
 **/
public class BaseException extends RuntimeException {

    public BaseException(){
        super();
    }

    public BaseException(String message){
        super(message);
    }

    public BaseException(Throwable throwable){
        super(throwable);
    }

    public BaseException(String message, Throwable throwable){
        super(message,throwable);
    }
}
