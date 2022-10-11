package thread;

/**
 * 同步块
 * 同步块可以更准确的锁定需要多个线程同步执行的代码片段，有效缩小同步范围
 * 可以保证并发安全的前提下尽可能提高并发效率
 * 语法
 * synchronized(同步监视器对象){
 *     需要同步执行的代码片段
 * }
 *
 */
public class SyncDemo2 {
    public static void main(String[] args) {
        shop shop = new shop();
        Thread t0 = new Thread("人物1"){
            @Override
            public void run() {
                shop.buy();
            }
        };

        Thread t1 = new Thread("人物2"){
            @Override
            public void run() {
                shop.buy();
            }
        };
        t0.start();
        t1.start();
    }
}

class shop{
    /*
    如果在方法上使用synchronized，那么同步监视器对象不可选，只能是
    当前方法的所属对象"this"

     */
    public void buy(){
        try {
            Thread t = Thread.currentThread();
            System.out.println(t.getName()+"：正在挑衣服");
            Thread.sleep(5000);

            /*
            同步块可以更精准的锁定需要多个线程同步执行的代码片段.
                使用同步块时要明确制定同步监视器对象,该对象需要同时满足:
                1:必须是一个引用类型的实例
                2:多个需要同步执行该代码片段的线程看到的必须是同一个
                  同步监视器对象
             */
            // new Object() 无效锁对象，凡是用实例化表达式作为锁对象一律无效
            // synchronized (t)  无效锁对象，每个线程看到的t都是它自身，因此它们之间看到的不是同一个对象
            /*
            synchronized (this){
                System.out.println(t.getName()+"：正在试衣间试衣服");
                Thread.sleep(5000);
            }
            */
            /*
            字符串字面量就不是一个合适的锁对象.
                因为字符串字面量始终表示同一个字符串对象,因此无论什么情况
                下多个线程执行这个同步块始终看到同一个字符串对象,因此时刻
                处于同步的,但是在不应当同步的时候也同步就不是合适的锁对象

             */
            synchronized ("abc"){  // 虽然有效但是不合适
                System.out.println(t.getName()+"：正在试衣间试衣服");
                Thread.sleep(5000);
            }

            System.out.println(t.getName()+"：结账离开");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
