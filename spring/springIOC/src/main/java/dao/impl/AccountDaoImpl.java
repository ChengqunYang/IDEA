package dao.impl;

import dao.AccountDao;
import domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class AccountDaoImpl implements AccountDao {
    private QueryRunner runner;

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    public List<Account> findAllAccount() throws SQLException {
        return runner.query("select * from account", new BeanListHandler<Account>(Account.class));
    }

    public Account findAccountById(Integer accountId) throws SQLException {
        return runner.query("select * from account where id = ?", new BeanHandler<Account>(Account.class), accountId);
    }

    public void saveAccount(Account account) throws SQLException {
        runner.update("insert into account(name,money)values(?,?)", account.getName(), account.getMoney());
    }

    public void updateAccount(Account account) throws SQLException {
        runner.update("update account set name=?,money=? where id = ?", account.getName(), account.getMoney(), account.getId());

    }

    public void deleteAccount(Integer accountId) throws SQLException {
        runner.update("delete from account where id = ?",accountId);
    }

    public Account findAccountByName(String accountName) throws SQLException {
        List<Account> accounts=  runner.query("select * from account where name = ?", new BeanListHandler<Account>(Account.class), accountName);
        if (accounts == null || accounts.size() == 0){
            return null;
        }
        if (accounts.size() > 1) {
            throw new RuntimeException("结果集不唯一,数据有问题");
        }
        return accounts.get(0);
    }
}
