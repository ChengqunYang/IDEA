package dao;

import domain.User;

import java.util.List;

/**
 * 用户的持久层接口
 */
public interface UserDao {
    /**
     * 查询所有用户,同时获取到用户下所有账户的信息
     * @return
     */
    List<User> findAll();


    /**
     * 根据用户id查询用户信息
     * @param userid
     * @return
     */
    User findById(Integer userid);


}
