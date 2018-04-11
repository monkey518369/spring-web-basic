package com.monkey.repository.system.pos;

import org.apache.ibatis.type.Alias;

import java.util.Date;

/**
 * @program: springbasic
 * @description: 用户职位实体类
 * @author: monkey
 * @create: 2018-03-22 22:37
 **/
@Alias("pos")
public class Pos {
    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    private String accountId;
    /**
     * 机构Id
     */
    private String orgId;
    /**
     * 机构Name(存储时不需要)
     */
    private String orgName;
    /**
     * 职位类型
     */
    private String grade;
    /**
     * 职位名称#{gradeName}
     */
    private String gradeName;
    /**
     * 职位类型
     */
    private Integer type;
    /**
     * 描述
     */
    private String description;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;
    /**
     * 关键字
     */
    private String keyWord;



    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }
}
