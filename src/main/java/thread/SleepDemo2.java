package thread;

/**
 * sleep的面试题：
 * 当调用方法Thread.sleep(1000),实际情况阻塞时间是：大于1秒钟的。
 *
 * sleep方法要求必须处理中断异常
 * 当一个线程调用sleep方法处于睡眠阻塞的过程中，该线程的interrupt方法
 * 被调用时，此时会打断其睡眠阻塞，sleep方法会抛出中断异常
 *
 */
public class SleepDemo2 {
    public static void main(String[] args) {
        Thread lin = new Thread(){
            public void run(){
                System.out.println("林：刚美完容，睡一会吧~");
                try {
                    Thread.sleep(100000000);
                } catch (InterruptedException e) {
                    System.out.println("林：干嘛呢！ 干嘛呢！ 干嘛呢！干嘛呢！");
                }
                System.out.println("林：醒了");
            }
        };

        Thread huang = new Thread(){
            @Override
            public void run() {
                System.out.println("黄：大锤80，小锤40!开始砸墙");
                for ( int i = 0; i < 4; i++ ) {
                    System.out.println("黄：80！");
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("轰~");
                System.out.println("黄：大哥，搞定！");
                lin.interrupt();
            }
        };

        lin.start();
        huang.start();


    }
}
