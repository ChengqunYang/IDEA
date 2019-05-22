package demo02.Stream;

import java.util.stream.Stream;

/*
    Stream流中的常用方法 concat :用于把流组合到一起
    如果有两个流,希望合并成一个流,那么可以使用Stream接口的静态方法concat
    static <T> Stream<T> concat (Stream<? extends T> a,Stream<? extends T> b)
 */
public class Demo08Stream_concat {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("张三丰", "张翠山", "张无忌", "周芷若", "赵敏");
        String[] arr = {"喜羊羊", "美羊羊", "懒羊羊", "灰太狼", "红太狼"};
        Stream<String> stream1 = Stream.of(arr);
        //把以上两个流组合为一个流
        Stream<String> concat = Stream.concat(stream, stream1);
        //遍历新的流
        concat.forEach(name-> System.out.println(name));

    }
}
