package demo06.Function;

import java.util.function.Function;

/*
    Function接口中的默认方法andThen,用来进行组合操作
    需求:
        把String类型的"123",转化为Integer类型,把转化后的结果加上10
        把增加之后的Integer类型的数据,转化为String类型
        分析:
            转化了两次
                1.把String类型的转化为Integer类型
                    所以我们可以使用Function<String, Integer> fun1
                    Integer i = fun1.apply("1234")+10;
                2.把Integer类型的转化为String类型
                    所以我们可以使用Function<Integer, String> fun2
                    String s = fun2.apply(i);
            所以我们可以使用Function接口的默认方法andThen(),把两次转化放在一起执行
            Strin s = fun1.andThen(fun2).apply("123");
            fun1先调用apply方法,将字符串转化为Integer
            fun2调用apply方法,将Integer转化为字符串
 */
public class Demo02Function_andThen {
    /*
        定义一个方法
            参数传递一个字符串类型的整数
            参数传递两个Function接口
                一个泛型使用<String, Integer>
                一个泛型使用<Integer, String>
     */
    public static void change(String s, Function<String ,Integer> fun1,Function<Integer,String> fun2){
        String ss = fun1.andThen(fun2).apply(s);
        System.out.println(ss);
        System.out.println(ss.getClass().toString());
    }

    public static void main(String[] args) {
        //定义一个String类型的整数
        String s = "123";
        //调用change方法,传递字符串和两个Lambda表达式
        change(s,(String str)->{
            //把字符串转化为整数,+10
            return Integer.parseInt(str)+10;
        },(Integer i)->{
            //把Integer类型的数据转化为字符串
            return i+"";
        });
    }
}
