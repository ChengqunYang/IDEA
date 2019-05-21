package demo05.Predicate;

import java.util.function.Predicate;

/*
    需求:
        判断字符串的长度是否大于5,
        如果长度大于5那么返回false,
        如果不大于5,结果返回true
        所以我们可以使用取反符号!,对判断的结果进行取反操作

        Predicate接口中有一个默认方法negate,也表示取反的意思

 */
public class Demo04Predicate_negate {
     /*
        定义一个方法,方法的参数,传递一个字符串
        传递一个Predicate接口
            一个用于判断字符串的长度是否大于5
     */
     public static boolean checkString(String s, Predicate<String> pre) {
         //return !pre.test(s);
         return pre.negate().test(s);
     }

    public static void main(String[] args) {
        //定义一个字符串,
        String s = "abddef";
        //调用checkString 方法,传递参数字符串和Lambda表达式
        boolean b = checkString(s,(str)->{
            //判断字符串的长度是否大于5,并返回结果
            return str.length()>5;
        });
        System.out.println(b);
    }
}
