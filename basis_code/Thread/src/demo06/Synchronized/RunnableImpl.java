package demo06.Synchronized;

/*
卖票案例出现了线程安全问题,卖出了不存在的票和重复的票
解决线程安全问题的第一种方案:使用同步代码块
格式:
    synchronized(锁对象){
    可能会出现线程安全问题的代码,共享数据的代码
    }
注意:
    1.同步代码块中的对象,可以使用同一对象
    2.但是必须保证多个线程使用的锁对象是同一个
    3.锁对象作用:
        把同步代码块锁住,只让一个线程在同步代码块中执行
解决线程安全问题的第二种方案:使用同步方法
    使用步骤:
        1.把访问了共享数据的代码抽取出来,放到一个方法中
        2.在方法中添加synchronized修饰符
    格式:定义方法的格式:
        修饰符 synchronized 返回值类型 方法名(参数列表){
            可能出现线程安全问题的代码(访问了共享数据的代码)
        }
注意:
    1.同步方法的锁对象是实现类的对象,new RunnableImpl() 也就是this
    2.也可以使用静态的同步方法.静态同步方法的锁对象是本类的class文件对象(反射机制)
解决线程安全问题的第三种方案:使用lock锁
    java.util.concurrent.locks.lock接口
    Lock实现提供了比synchronized方法和语句获得了更广泛的锁定操作
    Lock接口中的方法:
        void lock()获取锁
        void unlock() 释放锁
        java.util.concurrent.locks.ReentrantLock implements Lock 接口
    使用步骤:
        1.在成员位置创建一个ReentrantLock对象
        2.在可能出现安全问题的代码前调用lock接口中的方法lock获取锁
        3.在可能出现安全问题的代码后调用Lock接口中的方法unlock释放锁
 */
public class RunnableImpl implements Runnable {
    //定义一个多线程共享的资源
    private int ticket = 100;
    //创建一个锁对象
    Object obj = new Object();

    //设置线程任务:卖票
    @Override
    public void run() {
     //设置死循环让卖票重复进行
        while (true) {
            //同步代码块
            synchronized (obj){
                 //先判断票是否存在
                if (ticket > 0) {
                    //提高安全问题出现的概率
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    //票存在,卖票
                    System.out.println(Thread.currentThread().getName()+"正在卖第"+ticket+"张票");
                    ticket--;
                }
            }
        }
    }
}
