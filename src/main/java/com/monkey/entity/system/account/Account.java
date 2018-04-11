package com.monkey.entity.system.account;

import com.monkey.entity.BaseEntity;
import com.monkey.repository.system.pos.Pos;
import com.monkey.repository.system.role.Role;
import org.apache.ibatis.type.Alias;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @program: springbasic
 * @description: 用户实体类
 * @author: monkey
 * @create: 2018-03-22 22:26
 **/
@Alias("Account")
public class Account extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String loginName;

    private String password;

    private String salt;

    private String name;

    private String picUrl;

    private String appUrl;

    private String skin;

    private String email;

    private String wexinId;

    private String description;

    private Integer isValid;

    private String mobile;

    private String keyWord;

    private List<Pos> poss = new ArrayList<>();

    private List<Role> roles = new ArrayList<>();

    private String queryOrgID;

    private String orgName;

    private String rongCloudToken;

    private Set<String> urls;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getAppUrl() {
        return appUrl;
    }

    public void setAppUrl(String appUrl) {
        this.appUrl = appUrl;
    }

    public String getSkin() {
        return skin;
    }

    public void setSkin(String skin) {
        this.skin = skin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWexinId() {
        return wexinId;
    }

    public void setWexinId(String wexinId) {
        this.wexinId = wexinId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getIsValid() {
        return isValid;
    }

    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public List<Pos> getPoss() {
        return poss;
    }

    public void setPoss(List<Pos> poss) {
        this.poss = poss;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getQueryOrgID() {
        return queryOrgID;
    }

    public void setQueryOrgID(String queryOrgID) {
        this.queryOrgID = queryOrgID;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getRongCloudToken() {
        return rongCloudToken;
    }

    public void setRongCloudToken(String rongCloudToken) {
        this.rongCloudToken = rongCloudToken;
    }

    public Set<String> getUrls() {
        return urls;
    }

    public void setUrls(Set<String> urls) {
        this.urls = urls;
    }
}
