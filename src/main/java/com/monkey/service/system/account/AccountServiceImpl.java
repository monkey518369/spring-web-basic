package com.monkey.service.system.account;

import com.monkey.entity.system.account.Account;
import com.monkey.repository.system.account.AccountDao;
import com.monkey.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: springbasic
 * @description: 用户service实现类
 * @author: monkey
 * @create: 2018-03-22 22:11
 **/
@Service
public class AccountServiceImpl extends BaseServiceImpl<Account> implements AccountService {

    @Autowired
    private AccountDao accountDao;


    @Override
    public Account findByName(String name) {

        return accountDao.findByName(name);
    }
}
