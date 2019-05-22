package demo02.Stream;

import java.util.stream.Stream;

/*
    Stream流中的常用方法 skip:用于跳过元素
    如果希望跳过几个元素,可以使用skip方法获取一个截取之后的新流
    Stream<T> skip(long n);
        如果流的当前长度大于n,则跳过前n个,否则将会得到一个长度为0的空流
 */
public class Demo07Stream_skip {
    public static void main(String[] args) {
        //获取一个Stream流
        String[] arr = {"喜羊羊", "美羊羊", "懒羊羊", "灰太狼", "红太狼"};
        Stream<String> stream = Stream.of(arr);
        //使用skip方法跳过前三个元素
        Stream<String> stream1 = stream.skip(3);
        //遍历得到的新流
        stream1.forEach(name-> System.out.println(name));
    }
}
