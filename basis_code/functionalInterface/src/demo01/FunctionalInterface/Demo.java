package demo01.FunctionalInterface;

/**
 * 函数式接口的使用:一般作为方法的参数和返回值类型
 *
 */
public class Demo {
    //定义一个方法参数使用函数式接口MyFunctionalInterface
    public static void show(MyFunctionalInterface myInter) {
        myInter.method();
    }

    public static void main(String[] args) {
        //调用show方法,方法的参数是接口,所以可以传递接口的实现类对象
        show(new MyFunctionaIInterfaceImpl());

        //调用show方法,方法的参数是接口,所以我们可以传递接口的匿名内部类
        show(new MyFunctionalInterface(){
            @Override
            public void method() {
                System.out.println("使用匿名内部类重写接口中的抽象方法");
            }
        });
        //调用show方法,方法的参数是一个函数式接口,所以我们可以使用lambda表达式
        show(()->{
            //小括号中写抽象方法的参数,大括号是方法的重写
            System.out.println("使用lambda表达式重写接口的抽象方法");
        });
        //简化lambda表达式
        show(()-> System.out.println("使用lambda表达式重写接口的抽象方法")
        );

    }
}
