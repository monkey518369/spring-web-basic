package com.monkey.repository.system.account;

import com.monkey.annotation.repo.MonkeyBatis;
import com.monkey.entity.system.account.Account;
import com.monkey.repository.BaseDao;

/**
 * @program: springbasic
 * @description: 用户dao
 * @author: monkey
 * @create: 2018-03-22 22:23
 **/
@MonkeyBatis
public interface AccountDao extends BaseDao<Account>{

    Account findByName(String name);
}
