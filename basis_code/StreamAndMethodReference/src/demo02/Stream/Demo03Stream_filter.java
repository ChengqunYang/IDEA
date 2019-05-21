package demo02.Stream;

import java.util.stream.Stream;

/**
 * Stream流属于管道流,只能消费(使用)一次
 * 第一个Stream流调用完毕,数据就会到下一个Stream上\
 * 这时第一个Stream流已经使用完毕,就会关闭了
 * 所以第一个Stream流不能调用方法了
 */
/*
    Stream 流中的常用方法 filter:用于对Stream流中的数据进行过滤
    Stream<T> filter(Predicate<? super T> predicate);
    filter方法的参数Predicate是一个函数式接口,所以可以使用Lambda表达式,对数据进行过滤
    predicate中的抽象方法:
        boolean test(T t);
 */
public class Demo03Stream_filter {
    public static void main(String[] args) {
        //创建一个Stream流
        Stream<String> stream = Stream.of("张三丰", "张翠山", "张无忌", "周芷若", "赵敏");
        //对Stream流中的数据进行过滤,只留下姓张的人
        Stream stream1 = stream.filter((name)->{
            return name.startsWith("张");
            //当Predicate接口返回值为true时,将元素加入到新的流中
        });
        //遍历Stream1流
        stream1.forEach(name-> System.out.println(name));
    }
}
