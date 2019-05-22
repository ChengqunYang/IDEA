package deom05.ObjectMethodReference;
/*
    通过对象名引用成员方法
    使用前提是对象名是已经存在的,成员方法也是已经存在的
    就可以使用对象名来引用成员方法
 */
public class Demo01ObjectMethodReference {
    //定义一个方法,方法的参数传递Printable接口
    public static void printString(String s, Printable p) {
        p.print(s);
    }

    public static void main(String[] args) {
        String s = "Hello,World";
        //调用printString方法,方法的参数Printable是一个函数式接口,所以可以传递Lambda表达式
        printString(s,(str)->{
            //创建MethodRerObject对象
            MethodRerObject obj = new MethodRerObject();
            //调用MeathodRerObject对象中的成员方法,printUpperCaseString(),把字符串按照大写输出
            System.out.println(str);
            obj.printUpperCaseString(str);
        });
        /*
            使用方法引用来优化Lambda
            对象是已经存在的MethodRerObject
            成员方法也是已经存在的printUpperCaseString
            所以我们可以使用对象名来引用成员方法
         */
        //创建MethodRerObject对象
        MethodRerObject obj = new MethodRerObject();
        printString("zhangsan",obj::printUpperCaseString);
    }
}
