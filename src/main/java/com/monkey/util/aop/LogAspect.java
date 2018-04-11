package com.monkey.util.aop;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collection;
import java.util.Map;

@Aspect
@Component
public class LogAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("execution(* com.monkey..*.*(..))")
    public void pointCut(){}

    @Before("pointCut()")
    public void doBefore(JoinPoint jp){
        Signature signature = jp.getSignature();
        StringBuilder log = new StringBuilder();
        if(null != signature){
            log.append("now enter class: {}");
            log.append(signature.getDeclaringTypeName());
            log.append(", method: ").append(signature.getName());
            log.append(", args: ").append(ArgUtil.argsToString(jp.getArgs()));
        }
        LOGGER.info(log.toString());
    }

    @AfterReturning(value = "pointCut()",returning = "returnValue")
    public void doAfterReturn(JoinPoint jp,Object returnValue){
        StringBuilder log = new StringBuilder();
        Signature signature = jp.getSignature();
        if(null != signature){
            log.append("now leave class: ").append(signature.getDeclaringTypeName());
            log.append(", method: ").append(signature.getName());
            log.append(", args: ").append(ArgUtil.argsToString(jp.getArgs()));
            log.append(",returns: ");
            if(null != returnValue){
                log.append(returnValue.getClass().getName());
                if(returnValue instanceof Collection){
                    log.append("/size:").append(CollectionUtils.size(returnValue));
                }else if(returnValue instanceof Map){
                    log.append("/size:").append(CollectionUtils.size(((Map)returnValue).entrySet()));
                }else {
                    log.append(returnValue);
                }
            }else{
                log.append(returnValue);
            }

        }
        LOGGER.info(log.toString());
    }

    @AfterThrowing(value = "pointCut()",throwing = "ex")
    public void doAfterThrowing(JoinPoint jp,Exception ex){
        LOGGER.info("Exception thrown in method = " + jp.toString()+","+ex.getClass().getSimpleName()+"="+ex.getMessage());
        LOGGER.info(LogUtil.getStackTrace(ex));
    }

}

class ArgUtil{

    public static String argsToString(Object[] objects){
        StringBuilder result = new StringBuilder();
        result.append("[");

        if(ArrayUtils.isNotEmpty(objects)){
            for(Object obj : objects){
                if(obj instanceof Collection){
                    result.append(obj.getClass().getName());
                    result.append("/size:").append(CollectionUtils.size(obj));
                }else if(obj instanceof Map){
                    result.append(obj.getClass().getName());
                    result.append("/size:").append(CollectionUtils.size(((Map)obj).entrySet()));
                }else{
                    result.append(obj.toString());
                }
                result.append(" , ");
            }
        }
        String str = result.toString();
        if(StringUtils.endsWithIgnoreCase(str,",")){
            str = StringUtils.substringBeforeLast(str,",");
        }
        return str + "]";
    }

}

class LogUtil{

    public static String getStackTrace(Exception e) {
        StringWriter sw = null;
        PrintWriter pw = null;

        try {
            sw = new StringWriter();
            pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            pw.flush();
            sw.flush();
        } finally {
            if (sw != null) {
                try {
                    sw.close();
                } catch (IOException var9) {
                    var9.printStackTrace();
                }
            }

            if (pw != null) {
                pw.close();
            }

        }

        return sw.toString();
    }
}

