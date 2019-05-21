package demo02.Stream;

import java.util.*;
import java.util.stream.Stream;

/*
    java.util.stream.Stream<T>是java8新加入的最常用的接口,(这并不是一个函数式接口)
    获取一个流非常简单,有以下几种常用的方式:
        -所有的Collection集合都可以通过stream默认方法来获取Stream流;
            defult stream<E> stream()
        -Stream接口的静态方法of可以获取数组对应的流
            static<T> Stream<T> of (T....values)
             参数是一个可变参数,那么我们就可以传递一个数组
 */
public class Demo01GetStream {
    public static void main(String[] args) {
        //把集合转化为Stream流
        List<String> list = new ArrayList<>();
        Stream<String> stream1= list.stream();

        Set<String> set = new HashSet<>();
        Stream<String> stream2 = set.stream();


        //将map转化为Stream集合
        Map<String, String> map = new HashMap<>();
        //获取键,存储到一个Set集合中
        Set<String> keySet = map.keySet();
        Stream<String> stream3 = keySet.stream();

        //获取值,存储到一个Collection集合中
        Collection<String> values = map.values();
        Stream<String> stream4 = values.stream();

        //获取键值对(键与值的对应关系 entrySet)
        Set<Map.Entry<String, String>> entries = map.entrySet();

        //把数组转化为Stream流
        Stream<Integer> stream6 = Stream.of(1, 2, 3, 4, 5);

        //可变参数可以传递数组
        Integer[] arr = {1,2,3,4,5};
        Stream<Integer> stream7 = Stream.of(arr);
        String[] arr2 = {"张三", "李四", "王麻子"};
        Stream<String> stream8 = Stream.of(arr2);
    }
}
