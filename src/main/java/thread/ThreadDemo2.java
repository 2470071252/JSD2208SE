package thread;

import static java.lang.Thread.sleep;

/**
 * 第二种创建线程的方式
 * 实现Runnable接口单独定义线程
 */
public class ThreadDemo2 {
    public static void main(String[] args) {
        //1 实例化任务
        MyRunnable1 myRunnable1 = new MyRunnable1();
        MyRunnable2 myRunnable2 = new MyRunnable2();
        //2 实例化线程并指派任务
        Thread thread = new Thread(myRunnable1);
        Thread thread1 = new Thread(myRunnable2);
        // 调用start() 启动线程
        thread.start();
        thread1.start();

    }
}


class MyRunnable1 implements Runnable{
    @Override
    public void run() {
        // 需要做的事情
        for ( int i = 0; i < 1000; i++ ) {
            System.out.println("Who are you?");
            // 为了能够更直观的感受所以调用了sleep方法
            try {
                sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyRunnable2 implements Runnable{
    @Override
    public void run() {
        for ( int i = 0; i < 1000; i++ ) {
            System.out.println("FBI warning！");
            try {
                sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}