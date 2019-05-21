package demo05.Predicate;

import java.util.function.Predicate;

/*
   逻辑表达式:可以连接多个判断的条件
   &&:与运算符,有false则false
   ||:或运算符,有true则true
   !:非(取反)

   需求:判断一个字符串,有两个判断条件
        1.判断字符串的长度是否大于五
        2.判断字符串中是否包含a
      两个条件满足一个条件即可,我们就可以使用||运算符来连接两个条件

      Predicate接口中有一个默认方法or,表示或的关系,也可以用于连接两个判断条件
      or方法内部的两个判断条件,也是使用||运算符连接起来的
 */
public class Demo03Predicate_or {
    /*
        定义一个方法,方法的参数,传递一个字符串
        传递两个Predicate接口
            一个用于判断字符串的长度是否大于s
            一个用于判断字符串是否包含a
            两个条件满足一个即可
     */
    public static boolean checkString(String s, Predicate<String> pre1, Predicate<String> pre2) {
        //return pre1.test(s) || pre2.test(s);
       return pre1.or(pre2).test(s);
    }

    public static void main(String[] args) {
        //定义一个字符串
        String s = "bcdef";
        //调用checkString方法,参数传递字符串和两个Lambda表达式
        boolean b = checkString(s,(s1)->{
            return s1.length()>5;
        },(s1)->{
            return s1.contains("a");
        });
        System.out.println(b);
    }
}