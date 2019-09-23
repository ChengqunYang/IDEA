package service;

import domain.Account;

import java.sql.SQLException;
import java.util.List;

/**
 * 账户的业务层接口
 */
public interface AccountService {
    /**
     * 查询所有
     * @return
     */
    List<Account> findAllAccount() throws SQLException;

    /**
     * 查询一个
     * @return
     */
    Account findAccountById(Integer accountId) throws SQLException;

    /**
     * 保存操作
     * @param account
     */
    void saveAccount(Account account) throws SQLException;

    /**
     * 更新账户
     * @param account
     */
    void updateAccount(Account account) throws SQLException;

    /**
     * 根据id删除一个用户
     * @param accountId
     */
    void deleteAccount(Integer accountId) throws SQLException;

    /**
     * 转账
     * @param sourceName     转出账户名称
     * @param targetName     转入账户名称
     * @param money          转账金额
     */
    void transfer(String sourceName, String targetName, Float money) throws SQLException;
}
