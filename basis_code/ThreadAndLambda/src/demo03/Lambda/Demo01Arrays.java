package demo03.Lambda;

import java.util.Arrays;

/*
    lambda表达式有参数有返回值的练习
    需求:
        使用数组存储多个person对象
        对数组中的person对象使用Arrays的sort方法通过年龄来进行升序排列
 */
public class Demo01Arrays {
    public static void main(String[] args) {
        //使用数组存储多个person对象
        Person[] arr = {
                new Person("张三", 20),
                new Person("李四", 30),
                new Person("小明",10)
        };
        // 对数组中的person对象使用Arrays的sort方法通过年龄来进行升序(前面减去后面)排列
       /* Arrays.sort(arr, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge()-o2.getAge();
            }
        });*/
        //使用lambda表达式,简化匿名内部类
        Arrays.sort(arr,(Person o1,Person o2)-> {
            return o1.getAge()-o2.getAge();
        });
        //遍历数组
        for (Person p:
             arr) {
            System.out.println(p);

        }
    }
}
