package test;

import dao.UserDao;
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
import java.util.Date;
import java.util.List;

public class AnnotationCRUDTest {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private UserDao userDao;

    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();
        userDao = session.getMapper(UserDao.class);
    }

    @After
    public void destory() throws IOException {
        session.commit();
        session.close();
        in.close();
    }

    @Test
    public void testSave() {
        User user = new User();
        user.setUsername("mybatis annotation");
        user.setAddress("西安临潼区");

        userDao.saveUser(user);

    }

    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(34);
        user.setUsername("mybatis annotation");
        user.setAddress("西安临潼区");
        user.setSex("男");
        user.setBirthday(new Date());
        userDao.updateUser(user);
    }

    @Test
    public void testDelete() {
        userDao.deleteUser(31);
    }

    @Test
    public void testFindOne() {
        User user = userDao.findById(30);
        System.out.println(user);
    }

    @Test
    public void testFindByName(){
        List<User> users = userDao.FindUserByName("王");
        for (User u:users) {
            System.out.println(u);
        }
    }

    @Test
    public void findTotal() {
        int total = userDao.findTotalUser();
        System.out.println(total);
    }
}
