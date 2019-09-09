package test;

import dao.UserDao;
import domain.QueryVo;
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
public class MybatisTest {
    private InputStream in;
    private SqlSession sqlSession;
    private UserDao userDao;

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
        userDao = sqlSession.getMapper(UserDao.class);
    }

    @After
    public void destroy() throws IOException {
        //提交事务
        sqlSession.commit();
        //6.释放资源
        sqlSession.close();
        in.close();
    }

    @Test
    public void testFindAll() {

        //5.使用代理对象执行方法
        List<User> users = userDao.findAll();
        for (User user:users) {
            System.out.println(user);
        }
    }

    @Test
    public void testSave() {
        User user = new User();
        user.setUsername("mybites_saveuser_new");
        user.setAddress("西安市临潼区");
        user.setBirthday(new Date());
        user.setSex("男");
        System.out.println(user);
        //5.使用代理对象执行方法
        userDao.saveUser(user);
        System.out.println(user);

    }
    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(33);
        user.setUsername("hhh");
        user.setAddress("西安市临潼区");
        user.setBirthday(new Date());
        user.setSex("女");

        //5.使用代理对象执行方法
        userDao.updateUser(user);

    }
    @Test
    public void testdelete() {


        //5.使用代理对象执行方法
        userDao.deleteUser(34);

    }

    @Test
    public void testfindOne() {

        //5.使用代理对象执行方法
        User user = userDao.findById(24);
        System.out.println(user);

    }

    @Test
    public void testfindByName() {

        //5.使用代理对象执行方法
        List<User> users = userDao.findByName("王五");
        //List<User> users = userDao.findByName("王五");
        for (User user:users) {
            System.out.println(user);
        }
    }

    @Test
    public void testfindTotal() {
        //5.使用代理对象执行方法
        int total = userDao.findTotal();
        System.out.println(total);
    }


    @Test
    public void testfindByVo() {
        QueryVo vo = new QueryVo();
        User user = new User();
        user.setUsername("王五");
        vo.setUser(user);
        //5.使用代理对象执行方法
        List<User> users = userDao.findUserByVo(vo);
        //List<User> users = userDao.findByName("王五");
        for (User u:users) {
            System.out.println(u);
        }
    }

    @Test
    public void testfindByCondition() {
        User u = new User();
        u.setUsername("王五");
        u.setSex("2");
        List<User> users = userDao.findUserByCondition(u);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testfindInIds() {
        QueryVo vo = new QueryVo();
        List<Integer> list = new ArrayList<Integer>();
        list.add(16);
        list.add(22);
        list.add(25);
        vo.setIds(list);
        List<User> users = userDao.findUserInIds(vo);;
        for (User user : users) {
            System.out.println(user);
        }
    }
}
