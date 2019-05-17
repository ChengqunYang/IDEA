package demo01.getName;

/**
 * 线程的名称:
 *      主线程:main
 *      新线程:Thread-0,Thread-1,Thread-2
 */
public class GetThreadName {
    public static void main(String[] args) {
        //创建Thread类的子类对象
        MyThread mt = new MyThread();
        //调用start方法,开启新的线程,执行run方法
        mt.start();

        new MyThread().start();

        //输出主线程:
        System.out.println(Thread.currentThread().getName());

    }
}
