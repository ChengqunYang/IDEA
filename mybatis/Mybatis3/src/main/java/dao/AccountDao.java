package dao;

import domain.Account;

import java.util.List;

public interface AccountDao {
    /**
     * 查询所有账户,同时还要获取当前账户的所属用户信息
     * @return
     */
    List<Account> findAll();

    /**
     * 根据用户id查询账户信息
     * @param uid
     * @return
     */
    List<Account> findAccountByUid(Integer uid);
}
