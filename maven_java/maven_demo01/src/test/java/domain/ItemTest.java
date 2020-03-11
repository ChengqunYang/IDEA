package domain;

import dao.ItemsDao;
import dao.impl.ItemsDaoImpl;
import org.junit.Test;

import java.util.List;

public class ItemTest {
    @Test
    public  void findAll() throws Exception {
        ItemsDao itemsDao = new ItemsDaoImpl();
        List<Items> list = itemsDao.findAll();
        for (Items items:list) {
            System.out.println(items.getName());
        }
    }
}
