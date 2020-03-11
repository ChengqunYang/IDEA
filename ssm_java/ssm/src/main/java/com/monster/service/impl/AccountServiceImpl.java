package com.monster.service.impl;

import com.monster.dao.AccountDao;
import com.monster.domain.Account;
import com.monster.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    public List<Account> findAll() {
        System.out.println("业务层,查询所有的账户");
        return accountDao.findAll();
    }

    public void saveAccount(Account account) {
        System.out.println("业务层,保存账户");
        accountDao.saveAccount(account);
    }
}
