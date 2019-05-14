package demo01.FunctionalInterface;
/*
    函数式接口:有且只有一个抽象方法的接口称为函数式接口
    当然接口中可以包含其他的方法(静态,默认,私有的)
 */
@FunctionalInterface
//用于检测该接口是否是一个函数式接口
public interface MyFunctionalInterface {
    //定义一个抽象方法

    public abstract void method();
}
