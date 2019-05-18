package demo04.Lambda;
/*
    lambda 表达式有参数有返回值的练习
    需求:
        给定一个计算器Calculator接口,内含抽象方法calc()可以将两个int数字相加得到和值
        使用lambda表达式的标准格式调用invokeCalc方法,完成120和130的相加计算
 */
public class Demo01Calculator {
    public static void main(String[] args) {
        //调用invorkeCalc()方法,方法的参数是一个接口,可以使用lambda表达式
        invorkeCalc(10, 20, new Calculator() {
            @Override
            public int calc(int a, int b) {
                return a + b;
            }
        });
        /*
        * 使用lambda表达式简化匿名内部类的书写
        * */
        invorkeCalc(120,130,(int a,int b)->{
            return a + b;
        });
    }

    /*
        定义一个方法,参数传递两个int类型的整数
        参数传递Calculator接口
        方法内部调用Calculator中的方法salc计算两个整数的和
     */
    public static void invorkeCalc(int a, int b, Calculator c) {
        int sum = c.calc(a, b);
        System.out.println(sum);
    }
}
