package demo02.Stream;

import java.util.stream.Stream;

/*
    如果需要将流中的数据映射到另一个流中,可以使用map方法,
    <R> Stream<R> map(Function<? super T ,? extends R> mapper);
    该接口需要一个Function函数式接口参数,可以将当前流中的T类型,转化为另一种R类型的流
        Function中的抽象方法
            R apply(T t);
 */
public class Demo04Stream_map {
    public static void main(String[] args) {
        //1.获取一个String类型的Stream流
        Stream<String> stream = Stream.of("1", "2", "3", "4");
        //使用map方法,把字符串类型的流转化(映射)为Integer类型的流
        Stream<Integer> stream1 = stream.map((String s) -> {
            return Integer.parseInt(s);
        });
        stream1.forEach(i-> System.out.println(i));
    }
}
