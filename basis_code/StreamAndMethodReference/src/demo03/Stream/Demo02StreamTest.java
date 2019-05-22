package demo03.Stream;

import java.util.ArrayList;
import java.util.stream.Stream;

/*
    练习:集合元素处理(Stream)
    将上一个练习中的传统for循环写法更换为Stream流的方式处理
    两个集合的初始内容不变,Person类的定义不变
 */
public class Demo02StreamTest {
    public static void main(String[] args) {
        //第一支队伍
        ArrayList<String> one = new ArrayList<>();
        one.add("迪丽热巴");
        one.add("宋远桥");
        one.add("苏星河");
        one.add("石破天");
        one.add("石中玉");
        one.add("老子");
        one.add("庄子");
        one.add("洪七公");
        //1.第一个队伍只要名字为3个字的成员姓名,存储到一个新的集合中
        //2.第一个队伍筛选完之后只要前三个人,存储到一个新的集合中
        Stream<String> oneStream = one.stream().filter(name -> name.length() == 3).limit(3);
        //第二支队伍
        ArrayList<String> two = new ArrayList<>();
        two.add("古丽扎娜");
        two.add("张无忌");
        two.add("赵丽颖");
        two.add("张三丰");
        two.add("尼古拉斯");
        two.add("张天爱");
        two.add("张二狗");

        //3.第二个队伍只要姓张的成员姓名,存储到一个新的集合中
        //4.第二个队伍筛选之后不要前两个人,存储到一个新的集合中
        Stream<String> twoStream = two.stream().filter(name -> name.startsWith("张")).skip(2);


        //5.将两个队伍合并成一个队伍,存储到一个新的集合中
        //6.根据姓名创建Person对象,存储到一个新的集合中
        //7.打印整个队伍的Person对象信息
        Stream.concat(oneStream,twoStream).map(name->new Person(name)).forEach(p-> System.out.println(p));
    }
}