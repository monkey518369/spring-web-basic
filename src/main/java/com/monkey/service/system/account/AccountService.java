package com.monkey.service.system.account;

import com.monkey.entity.system.account.Account;
import com.monkey.service.BaseService;

/**
 * @program: springbasic
 * @description: 用户service
 * @author: monkey
 * @create: 2018-03-22 22:11
 **/
public interface AccountService extends BaseService<Account>{

    Account findByName(String name);

}
