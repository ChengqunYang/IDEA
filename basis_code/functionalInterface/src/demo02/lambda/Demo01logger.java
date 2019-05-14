package demo02.lambda;
/*
    日志案例
    发现以下代码中存在一些性能浪费的为题
    调用showLog方法,传递的第二个参数是一个拼接后的字符串
    先把字符串拼接好,然后在调用showLog方法,
    showLog方法中如果传递的日志级别不是1,那么字符串就白拼接了
    存在浪费
 */
public class Demo01logger {
    //定义一个根据日志的级别显示日志信息的方法
    public static void showLog(int level,String message){
        //对日志的等级进行判断,如果是级别1,那么输出日志信息
        if (level==1){
            System.out.println(message);
        }
    }
    public static void main(String[] args){
        //定义三个日志信息
        String msg1 = "Hello";
        String msg2 = "World";
        String msg3 = "Java";

        //调用showLog方法,传递日志级别和日志信息
         showLog(1,msg1+msg2+msg3);
    }
}
