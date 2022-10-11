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
    public void buy(){
        try {
            Thread t = Thread.currentThread();
            System.out.println(t.getName()+"：正在挑衣服");
            Thread.sleep(5000);

            /*
            同步块可以更精准的锁定需要多个线程
             */
            synchronized (this){
                System.out.println(t.getName()+"：正在试衣间试衣服");
                Thread.sleep(5000);
            }

            System.out.println(t.getName()+"：结账离开");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
