package demo05.Lambda;

import java.util.ArrayList;

/**
 * Lambda表达式是可推到可省略的
 *      凡是根据上下文推导出来的东西我们都可以省略书写
 *      可以省略的内容:
 *          1.(参数列表):括号中参数列表的类型可以省略不写
 *          2.(参数列表):括号中的参数如果只有一个那么小括号也可以省略
 *          3.(一些代码):如果{}中的代码只有一行,无论是否有返回值,都可以省略({},return,分号)
 *      注意:
 *          要省略({},return,分号)则必须一起省略
 */
public class Demo01ArrayList {
    public static void main(String[] args) {
        //JDK1.7版本之前,创建集合对象,必须把前后的泛型都写上
        ArrayList<String> list01 = new ArrayList<String>();
        //JDK1.7 =号后面的泛型可以省略,后面的泛型可以将前面的泛型推到出来
        ArrayList<String> list = new ArrayList<>();
    }

}