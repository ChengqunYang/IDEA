package demo01.getName;

/**
 * 获取线程的名称:
 *      1.使用Thread类中的方法getName()
 *      String getName();来获取线程的名称
 *      2.可以先获取到当前正在执行的线程,使用线程中的getName()方法来获取线程名称
 *          static  Thread CurrentThread(); 返回当前正在执行的线程对象的引用
 *
 */
//定义一个Thread类的子类
public class MyThread extends Thread{
    //重写thread类中的run方法设置线程任务
    @Override
    public void run() {
         //获取线程的名称
        //String name = getName();
        //System.out.println(name);

        //获取线程的名称
        Thread t = Thread.currentThread();
       // System.out.println(t);
       // String name = t.getName();
        //System.out.println(name);

        //链式编程:
        System.out.println(Thread.currentThread().getName());

    }

}
