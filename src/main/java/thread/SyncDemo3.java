package thread;
/**
 * 当一个静态方法上使用synchronized后，那么该方法[一定是同步]的（有先后顺序）
 */
public class SyncDemo3 {
    public static void main(String[] args) {
        Foo f1 = new Foo();
        Foo f2 = new Foo();
        Thread thread1 = new Thread(){
            @Override
            public void run() {
               f1.dosome();
            }
        };
        Thread thread2 = new Thread(){
            @Override
            public void run() {
               f2.dosome();
            }
        };
        thread1.start();
        thread2.start();
    }
}

class Foo{
    public synchronized static void dosome(){
        Thread t = Thread.currentThread();
        System.out.println(t.getName()+"：正在执行dosome方法");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(t.getName()+"：执行dosome方法完毕");
    }
}

