package demo09.ArrayMethodReference;
/*
    数组的构造器引用
 */
public class Demo {
    /*
        定义一个方法
        方法的参数传递创建数组的长度和ArrayBuilder接口
        方法的内部根据传递的数组的长度调用builderArray()方法创建一个数组并返回
     */
    public static int[] createArray(int length, ArrayBuilder ab) {
        return ab.builderArray(length);
    }

    public static void main(String[] args) {
        //调用createArray方法来创建一个数组
        int[] arr1 = createArray(5,(len)->{
           return new int[len];
        });
        System.out.println(arr1.length);
        //使用方法引用来优化Lambda表达式
        //int[] 引用new
        int[] arr2 = createArray(8,int[]::new);
        System.out.println(arr2.length);
    }
}
