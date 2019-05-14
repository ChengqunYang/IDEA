package test;

import model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class Demo01 {
    @Test
    public void test1() throws IOException {
        //1.读取配置文件
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.通过SqlSessionFactoryBuilder创建sqlSessionFactory会话工厂
        SqlSessionFactory sessionFactoy = new SqlSessionFactoryBuilder().build(is);
        //3.通过SqlSessionFactory创建SqlSession
        SqlSession session = sessionFactoy.openSession();
        //4.调用SqlSession的操作数据库方法
        User user = session.selectOne("findUserById", 10);
        System.out.println(user);
        //5.关闭SqlSession
        session.commit();
    }
}
