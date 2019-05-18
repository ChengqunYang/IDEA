package demo01.WaitAndNotify;
/*
 生产者(包子铺类)是一个线程类,可以继承Thread
 设置线程任务(run)生产包子:
 true:有包子
    包子铺调用wait方法,进入等待状态
 false:没有包子
    包子铺生产包子
    添加一些别的包子类型:(交替生产两种包子)
        有两种状态:(i%2==0)
    包子铺生产好包子
    修改包子状态为true有
    唤醒吃货线程,让吃货线程吃包子
注意:
    包子铺线程和吃货线程关系(通信关系(互斥))
    必须采取同步技术来保证两个线程只有一个在执行
    锁对象必须保证唯一,可以使用包子对象作为锁对象
    包子铺类和吃货类就需要把包子对象作为参数传递过来
        1.需要在成员位置创建一个包子变量
        2.使用带参数的构造方法来为这个包子变量赋值
 */
public class BaoZiPu extends Thread{
    //1.需要在成员位置创建一个包子变量
    private BaoZi bz;

    public BaoZiPu(BaoZi bz) {
        this.bz = bz;
    }
    //设置线程任务(run)生产包子
    @Override
    public void run() {
        //定义一个变量
        int count = 0;
        // 必须采取同步技术来保证两个线程只有一个在执行
        //让包子铺一直生产包子
        while (true) {
        synchronized (bz) {
            if (bz.flag == true) {
                // 包子铺调用wait方法,进入等待状态
                try {
                    bz.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            //唤醒之后执行,包子铺生产包子
            //交替生产两种包子
            if (count % 2 == 0) {
                //生产薄皮三鲜馅包子
                bz.pi = "薄皮";
                bz.xian = "三鲜馅";
            } else {
                //生产 冰皮 牛肉大葱馅
                bz.pi="冰皮";
                bz.xian="牛肉大葱馅";
            }
            count++;
            System.out.println("包子铺正在生产:"+bz.pi+bz.xian+"包子");
            //生产包子需要三秒钟
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //包子铺生产好包子
            //修改包子状态为true有
            bz.flag = true;
            //唤醒吃货线程,让吃货线程吃包子
            bz.notify();
            System.out.println("包子铺已经生产好了:" + bz.pi + bz.xian + "包子,吃货可以吃了");
            }
        }
    }
}
