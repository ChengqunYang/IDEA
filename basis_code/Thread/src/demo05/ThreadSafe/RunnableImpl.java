package demo05.ThreadSafe;

/*
实现买票案例
 */
public class RunnableImpl implements Runnable {
    //定义一个多线程共享的资源
    private int ticket = 100;

    //设置线程任务:卖票
    @Override
    public void run() {
     //设置死循环让卖票重复进行
        //先判断票是否存在
        while (true) {
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
