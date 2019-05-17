package demo07.WaitAndNotify;

/*
等待唤醒案例:进程间通信
    创建一个顾客线程(消费者)告知老板要的包子的种类和数量,调用wait方法放弃cpu的占用,进入到(WAITING)无限等待状态
    创建一个老板线程(生产者)花了五秒做包子,包子做好之后,调用notify唤醒顾客,吃包子
注意:
    顾客和老板必须同步代码块包裹起来,保证等待和唤醒只能有一个在执行
    同步使用的锁对象必须保证唯一
    只有锁对象才能使用wait和notify方法
    object类中的方法:
    void wait()
        在其他线程调用此对象notify()方法和notifyAll()方法前,导致当前的线程等待
    void notify()
        唤醒在此对象监视器上等待的单个线程.
        会继续执行wait方法之后的代码
 */
public class Demo01WaitAndNotify {
    public static void main(String[] args) {
        //创建锁对象,保证唯一
        Object obj = new Object();
        //创建一个顾客线程(消费者)
        new Thread(){
            @Override
            public void run() {
                //一直等着买包子
                while (true) {
                    //保证等待和唤醒状态只能有一个执行,所以使用同步技术
                    synchronized (obj) {
                        System.out.println("告诉老板要的包子种类和数量");
                        //调用wait方法放弃cpu的占用,进入到(WAITING)无限等待状态
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //唤醒之后执行的代码
                        System.out.println("包子真好吃");
                        System.out.println("--------------");
                    }
                }
            }
        }.start();
        //创建一个老板线程(生产者)
        new Thread(){
            @Override
            public void run() {
                //一直让他做包子
                while (true) {
                    //花五秒钟来做包子
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //保证等待和唤醒的线程只能有一个执行,需要使用同步技术
                    synchronized (obj) {
                        System.out.println("老板五秒钟之后做好包子,告知顾客,可以吃包子了");
                        //做好包子后,调用notify方法,唤醒顾客吃包子
                        obj.notify();
                    }
                }
            }
        }.start();
    }
}
