package dao;

import domain.Account;

import java.sql.SQLException;
import java.util.List;

/**
 * 账户的持久层接口
 */
public interface AccountDao {
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
     * 根据名称查询账户
     * @param accountName
     */
    Account findAccountByName(String accountName) throws SQLException;
}
