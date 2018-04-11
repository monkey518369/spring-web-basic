package com.monkey.util.shiro.realm;

import com.monkey.entity.system.account.Account;
import com.monkey.service.system.account.AccountService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.pam.UnsupportedTokenException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: springbasic
 * @description: 登陆realm
 * @author: monkey
 * @create: 2018-03-22 22:09
 **/
public class MyLoginRealm extends AuthorizingRealm {

    private static final Logger log = LoggerFactory.getLogger(MyLoginRealm.class.getName());

    @Autowired
    AccountService accountService;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        if(!(authenticationToken instanceof UsernamePasswordToken)){
            throw new UnsupportedTokenException("不支持的token类型");
        }

        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        String name = token.getUsername();
        String password = new String(token.getPassword());

        Account account = accountService.findByName(name);
        log.info(account.getName()+"=="+account.getPassword());
        System.out.println("login+++++++++++++++++++++");
        password = (new Md5Hash(password,null,2)).toBase64();
        log.info("new password:"+password);
        return new SimpleAuthenticationInfo(name,password,this.getClass().getName());
    }
}
