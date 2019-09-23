package test;

import domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.AccountService;

import java.sql.SQLException;
import java.util.List;

/**
 * 使用Junit单元测试,测试我们的配置
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class AccountServiceTest {
    @Autowired
    private AccountService as;

    @Test
    public void testfindAll() throws SQLException {
        //3.执行方法
        List<Account> accounts = as.findAllAccount();
        for (Account account:accounts) {
            System.out.println(account);

        }
    }

    @Test
    public void testFindOne() throws SQLException {

        Account account = as.findAccountById(1);
        System.out.println(account);
    }
    @Test
    public void testSave() throws SQLException {
        Account account = new Account();
        account.setName("小温");
        account.setMoney(10000000);

        as.saveAccount(account);
    }

    @Test
    public void testUpdate() throws SQLException {

        Account account = as.findAccountById(4);
        account.setMoney(2000000);
        as.updateAccount(account);
    }

    @Test
    public void testDelete() throws SQLException {

        as.deleteAccount(1);
    }

    @Test
    public void testTranfer() throws SQLException {
        as.transfer("小温","小水",1000f);
    }
}
