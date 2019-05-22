package demo02.Stream;

import java.util.stream.Stream;

/*
    Stream流中的常用方法 limit:用于截取流中的元素
    limit方法可以对流进行截取,只取用前n个,方法格式:
        Stream<T> limit(long maxsize);
    参数是一个Long类型的整数,如果当前流中的元素大于参数,则截取,否则不执行操作
    limit方法是一个延迟方法,只是对流中的元素进行截取,返回的是一个新的流,所以可以继续调用Stream流中的其他方法
 */
public class Demo06Stream_limit {
    public static void main(String[] args) {
        //获取一个流
        String[] arr = {"喜羊羊", "美羊羊", "懒羊羊", "灰太狼", "红太狼"};
        Stream<String> stream = Stream.of(arr);
        //使用limit方法对Stream流中的元素进行截取,只取前三个元素
        Stream<String> stream1 = stream.limit(3);
        //遍历stram1,将其中的元素输出
        stream1.forEach(name-> System.out.println(name));
    }
}
