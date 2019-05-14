package dao.impl;

import dao.ItemsDao;
import domain.Items;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemsDaoImpl implements ItemsDao {
    public List<Items> findAll() throws Exception {
        //把数据库结果转成java的List集合
        List<Items> list = new ArrayList<Items>();
        //先获取connection的对象
        Connection connection =null;
        //获取真正操作数据的对象
        PreparedStatement pst = null;
        //执行数据库查询操作
        ResultSet rs = null;
        try {
            //加载驱动类
            Class.forName("com.mysql.jdbc.Driver");
            //先获取connection的对象
            connection = DriverManager.getConnection("jdbc:mysql:///maven","root","975864");
            //获取真正操作数据的对象
            pst = connection.prepareCall("SELECT * FROM items");
            //执行数据库查询操作
            rs = pst.executeQuery();

            while (rs.next()) {
                Items items = new Items();
                items.setId(rs.getInt("id"));
                items.setName(rs.getString("name"));
                list.add(items);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            connection.close();
            pst.close();
            rs.close();
        }
        return list;
    }
}
