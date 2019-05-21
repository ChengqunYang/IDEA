package demo05.Predicate;

import java.util.ArrayList;
import java.util.function.Predicate;

/*
    练习:集合信息筛选
        数组当中有多条"姓名+性别"的信息如下
        String[] array = {"迪丽热巴,女","古丽扎娜,女","马尔扎哈,男","赵丽颖,女"}
        请通过Predicate接口中方法将符合要求的字符串筛选到ArrayList中
        需要同时满足两个条件:
            1.必须为女生
            2.姓名必须为四个字

        分析:
            1.有两个判断条件,所以需要使用两个Predicate接口,对条件进行判断
            2.必须同时满足两个条件,所以可以使用and方法,连接两个判断条件
 */
public class Demo05Test {
    /*
    定义一个方法
    方法的参数传递一个包含人员信息的数组
    传递两个Predicate接口(两个判断条件),用于对数据进行过滤
    把满足条件的信息存到ArrayList集合中并返回
     */
    public static ArrayList<String> filter(String[] arr, Predicate<String> pre1,Predicate<String> pre2) {
        //定义一个ArrayList集合,存储过滤之后的信息
        ArrayList<String> list = new ArrayList<>();
        //遍历数组,获取数组中的信息
        for (String s:arr) {
            //使用Predicate接口中的test方法对获取到的数据进行判断
            boolean b = pre1.and(pre2).test(s);
            //对得到的布尔值进行判断
            if(b){
                //条件成立,两个条件满足,把信息存放到ArrayList集合中
                list.add(s);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        //定义一个存储信息的数组
        String[] array = {"迪丽热巴,女","古丽扎娜,女","马尔扎哈,男","赵丽颖,女"};
        //调用filter方法,传递字符串数组和两个Lambda表达式
        ArrayList<String> list = filter(array,(String s)->{
            //获取字符串中的性别,判断是否为女
            return s.split(",")[1].equals("女");
        },(String s)->{
            //判断字符串中的姓名,是否等于4
            return s.split(",")[0].length()==4;
        });
        //遍历集合
        for (String s:list) {
            System.out.println(s);
        }
    }
}
