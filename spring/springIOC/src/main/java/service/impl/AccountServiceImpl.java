package service.impl;

import dao.AccountDao;
import domain.Account;
import service.AccountService;

import java.sql.SQLException;
import java.util.List;

/**
 * 账户的业务层实现类
 */

public class AccountServiceImpl implements AccountService{

    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> findAllAccount() throws SQLException {
        return accountDao.findAllAccount();
    }

    public Account findAccountById(Integer accountId) throws SQLException {
        return accountDao.findAccountById(accountId);
    }

    public void saveAccount(Account account) throws SQLException {
        accountDao.saveAccount(account);
    }

    public void updateAccount(Account account) throws SQLException {
        accountDao.updateAccount(account);
    }

    public void deleteAccount(Integer accountId) throws SQLException {
        accountDao.deleteAccount(accountId);

    }

    public void transfer(String sourceName, String targetName, Float money) throws SQLException {
        //1.根据名称查询转入账户
        Account source = accountDao.findAccountByName(sourceName);
        //2.根据名称查询转出账户
        Account target = accountDao.findAccountByName(targetName);
        //3.转出账户减钱
        source.setMoney(source.getMoney() - money);
        //4.转入账户加钱
        target.setMoney(target.getMoney() + money);
        //5.更新转出账户
        accountDao.updateAccount(source);
        //6.更新转入账户
        accountDao.updateAccount(target);
    }
}
