package dao;

import domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.io.InputStream;
import java.util.List;

/**
 * 在mybatis中针对crud一共有四种注解
 * @Select @Update @Delete @Insert
 */
//开启二级缓存的使用
@CacheNamespace(blocking = true)
public interface UserDao {

    /**
     * 查询所有用户
     * @return
     */
    @Results(id = "userMap",value = {
            @Result(property = "accounts",column = "id",
                    many = @Many(select = "dao.AccountDao.findAccountByUid",
                            fetchType = FetchType.LAZY))
    })
    @Select("select * from user")
    List<User> findAll();

    /**
     * 保存用户
     * @param user
     */
    @Insert("insert into user(username,address,sex,birthday) values(#{username},#{address},#{sex},#{birthday})")
    void saveUser(User user);

    /**
     * 更新用户
     * @param user
     */
    @Update("update user set username=#{username},sex=#{sex},birthday=#{birthday},address=#{address} where id=#{id}")
    void updateUser(User user);

    /**
     * 删除用户
     * @param userId
     */
    @Delete("delete from user where id =#{id}")
    void deleteUser(Integer userId);

    /**
     * 根据用户id查询用户
     * @param userid
     */
    @Select("select * from user where id=#{id}")
    User findById(Integer userid);

    /**
     * 根据用户名称模糊查询
     * @param username
     * @return
     */
   /* @Select("select * from user where username like \"%\"#{username}\"%\"")*/
   @Select("select * from user where username like '%${value}%'")
    List<User> FindUserByName(String username);


    /**
     * 查询总用户数量
     * @return
     */
    @Select("select count(*) from user")
    int findTotalUser();

}
