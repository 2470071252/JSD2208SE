package thread;

/**
 * 互斥性
 * 当时用多个synchronized锁定多个代码片段，并且指定了相同的同步监视器对象时
 * 那么这些代码片段之间就是互斥的，多个线程不能同时执行它们
 */
public class SyncDemo4 {
    public static void main(String[] args) {
        Boo boo = new Boo();
        Thread t1 = new Thread() {
            public void run() {
                boo.methodA();
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                boo.methodB();
            }
        };
        t1.start();
        t2.start();
    }
}

class Boo {
    public synchronized void methodA() {
        try {
            Thread t = Thread.currentThread();
            System.out.println(t.getName() + "正在执行A方法。。。");
            Thread.sleep(5000);
            System.out.println(t.getName() + "执行A方法完毕!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //    public synchronized void methodB(){
    public void methodB() {
        synchronized (this) {
            try {
                Thread t = Thread.currentThread();
                System.out.println(t.getName() + "正在执行B方法。。。");
                Thread.sleep(5000);
                System.out.println(t.getName() + "执行B方法完毕!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}