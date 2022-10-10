package thread;

/**
 * 以匿名内部类形式完成线程的两种创建模式
 */
public class ThreadDemo3 {
    public static void main(String[] args) {
        // 第一种创建线程的方式
        Thread t1 = new Thread() {
            @Override
            public void run() {
                for ( int i = 0; i < 1000; i++ ) {
                    System.out.println("Who are you?");
                }
            }
        };
        /*
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                for ( int i = 0; i < 1000; i++ ) {
                    System.out.println("FBI！！！");
                }
            }
        };
         */

        /*
        // Runnable接口可以使用lambda表达式创建
        Runnable r2 = () -> {
            for ( int i = 0; i < 1000; i++ ) {
                System.out.println("FBI！！！");
            }
        };
        Thread t2 = new Thread(r2);
        */

        // Runnable接口可以使用lambda表达式创建2
        Thread t2 = new Thread(() -> {
            for ( int i = 0; i < 1000; i++ ) {
                System.out.println("FBI!!!");
            }
        });

        t1.start();
        t2.start();
    }
}
