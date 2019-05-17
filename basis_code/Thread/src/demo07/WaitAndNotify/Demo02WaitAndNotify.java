package demo07.WaitAndNotify;

/**
 * 进入到TimeWaiting(记时等待)有两种方式:
 * 1.使用sleep(long m)方法,在毫秒值结束之后线程睡醒,进入Runnable或者Blocked状态
 * 2.使用wait(long m)方法,wait()方法如果在毫秒值结束之后,还没有被notify唤醒,就会自动唤醒,线程进入Runnable或者Blocked状态
 *唤醒方法:
 * void notify()唤醒在此对象监视器上等待的单个线程
 * void notifyAll()唤醒在此对象监视器上等待的所有线程
 */
public class Demo02WaitAndNotify {
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
                        System.out.println("顾客1告诉老板要的包子种类和数量");
                        //调用wait方法放弃cpu的占用,进入到(WAITING)无限等待状态
                        try {
                            obj.wait(5000);
                            //相当于sleep方法
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //唤醒之后执行的代码
                        System.out.println("顾客1开吃");
                        System.out.println("--------------");
                    }
                }
            }
        }.start();

        //创建一个顾客线程(消费者)
        new Thread(){
            @Override
            public void run() {
                //一直等着买包子
                while (true) {
                    //保证等待和唤醒状态只能有一个执行,所以使用同步技术
                    synchronized (obj) {
                        System.out.println("顾客2告诉老板要的包子种类和数量");
                        //调用wait方法放弃cpu的占用,进入到(WAITING)无限等待状态
                        try {
                            obj.wait(5000);
                            //相当于sleep方法
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //唤醒之后执行的代码
                        System.out.println("顾客2开吃");
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
                        //obj.notify();//如果有多个线程等待,随机唤醒一个
                        obj.notifyAll();//唤醒所有等待的线程
                    }
                }
            }
        }.start();
    }
}
