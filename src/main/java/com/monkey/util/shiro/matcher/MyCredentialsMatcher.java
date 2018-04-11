package com.monkey.util.shiro.matcher;


import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.hash.AbstractHash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @program: springbasic
 * @description: 密码验证
 * @author: monkey
 * @create: 2018-03-23 16:52
 **/
public class MyCredentialsMatcher extends HashedCredentialsMatcher {

    private Logger log = LoggerFactory.getLogger(MyCredentialsMatcher.class.getName());

    private String credentialType;

    public String getCredentialType() {
        return credentialType;
    }

    public void setCredentialType(String credentialType) {
        this.credentialType = credentialType;
    }

    /*@Override
    protected Object getCredentials(AuthenticationInfo info) {
        Object credentials = info.getCredentials();
        byte[] storedBytes = this.toBytes(credentials);
        if (credentials instanceof String || credentials instanceof char[]) {
            if (this.isStoredCredentialsHexEncoded()) {
                storedBytes = Hex.decode(storedBytes);
            } else {
                storedBytes = Base64.decode(storedBytes);
            }
        }

        AbstractHash hash = this.newHashInstance();
        hash.setBytes(storedBytes);
        return hash;
    }*/


}
