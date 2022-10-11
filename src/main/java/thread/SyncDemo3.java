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
    /*
    静态方法上如果使用了synchronized，那么同步监视器对象不可选，
    是当前类的类对象。(Foo.class)
    class类，它的每一个实例用于表示JVM加载的一个类，因此Class类的实例
    就被称为一个类的类对象，在JVM内部每个被加载的类都有且只有一个Class
    实例与之对应
     */
    //    public synchronized static void dosome(){
    public static void dosome(){
        Thread t = Thread.currentThread();
        System.out.println(t.getName()+"程序开始");
        synchronized (Foo.class){   // 只要在静态方法用使用同步块，同步监视器对象使用类名.class(当前类对象) 一定好使
            System.out.println(t.getName()+"：正在执行dosome方法");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(t.getName()+"：执行dosome方法完毕");
        }

    }
}

