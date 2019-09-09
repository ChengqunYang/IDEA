package test;

import dao.AccountDao;
import dao.UserDao;
import domain.Account;
import domain.AccountUser;
import domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * mybatis的crud操作
 */
public class AccountTest {
    private InputStream in;
    private SqlSession sqlSession;
    private AccountDao accountDao;

    @Before
    public void init() throws IOException{
        //1.读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂生产Session对象
        sqlSession = factory.openSession();
        //4.使用SqlSession创建Dao接口的代理对象
        accountDao = sqlSession.getMapper(AccountDao.class);
    }

    @After
    public void destroy() throws IOException {
        //提交事务
        sqlSession.commit();
        //6.释放资源
        sqlSession.close();
        in.close();
    }

    /**
     * 测试查询所有
     */
    @Test
    public void testfindAll() {
    List<Account> accounts = accountDao.findAll();
        for (Account account:accounts) {
            System.out.println(account);
            System.out.println(account.getUser());

        }
    }

    /**
     * 测试查询所有账户,同时包含用户名称和地址
     */
    @Test
    public void testfindAllAccountUser() {
        List<AccountUser> accountUsers = accountDao.findAllAccount();
        for (AccountUser account:accountUsers) {
            System.out.println(account);

        }
    }

}
