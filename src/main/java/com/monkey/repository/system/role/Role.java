package com.monkey.repository.system.role;

/**
 * @program: springbasic
 * @description: 角色实体类
 * @author: monkey
 * @create: 2018-03-22 22:39
 **/
public class Role {

    private static final long serialVersionUID = 1L;
    /**
     * 机构Id
     */
    private String orgId;
    /**
     * 名称
     */
    private String name;
    /**
     * 状态
     */
    private Integer isValid;
    /**
     * 描述
     */
    private String description;

    private String keyWord;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIsValid() {
        return isValid;
    }

    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }
}
