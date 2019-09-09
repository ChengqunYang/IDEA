package dao;

import domain.QueryVo;
import domain.User;

import java.util.List;

/**
 * 用户的持久层接口
 */
public interface UserDao {
    /**
     * 查询所有操作
     * @return
     */
    List<User> findAll();

    /**
     * 保存用户
     * @param user
     */
    void saveUser(User user);

    /**
     * 更新用户
     * @param user
     */
    void updateUser(User user);

    /**
     * 根据用户id删除用户
     * @param userid
     */
    void deleteUser(Integer userid);

    /**
     * 根据用户id查询用户信息
     * @param userid
     * @return
     */
    User findById(Integer userid);

    /**
     * 跟用名称模糊查询用户信息
     * @param username
     * @return
     */
    List<User> findByName(String username);

    /**
     * 查询用户的总数
     * @return
     */
    int findTotal();

    /**
     * 根据QueryVo中的条件查询用户
     *
     * @param vo
     * @return
     */
    List<User> findUserByVo(QueryVo vo);

    /**
     * 根据传入的参数条件
     * @param user 查询的条件,有可能有姓名,有可能有地址,有可能啥都有,也有可能啥都没有
     * @return
     */
    List<User> findUserByCondition(User user);

    /**
     * 根据queryvo中提供的id集合,查询用户信息
     * @param vo
     * @return
     */
    List<User> findUserInIds(QueryVo vo);
}
