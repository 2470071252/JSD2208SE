package thread;

/**
 * 多线程
 * 线程的第一种创建方式：
 * 继承Thread并重写
 *
 */
public class ThreadDemo{
    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        MyThread2 myThread2 = new MyThread2();
        myThread1.start();  // 会自动调用run();
        myThread2.start();
    }
}
/**
 * 第一种创建线程的方式
 * 优点：结构简单，有利于匿名内部类形式创建
 * 缺点：
 * 1.存在继承冲突问题
 *  由于java是单继承的，如果继承了Thread则无法再继承其他类去复用方法
 *  这在实际开发中非常不方便
 * 2.当定义线程的同时，我们重写了run方法并将线程任务定义在其中
 *  这导致了线程与线程任务存在了必然的耦合关系，这不利于线程的重用。
 *
 */
class MyThread1 extends Thread{
    @Override
    public void run() {
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

class MyThread2 extends Thread{
    @Override
    public void run() {
        for ( int i = 0; i < 1000; i++ ) {
            System.out.println("开门，查水表的！");
            try {
                sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

