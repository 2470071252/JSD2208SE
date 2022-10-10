package thread;

/**
 * 线程优先级
 * 线程有10个优先级，分别用整数1-10表示，其中1为最低优先级
 * 5为默认优先级
 * 线程优先级越高的线程获取CPU时间片的概率越高。
 */
public class PriorityDemo {
    public static void main(String[] args) {
        Thread min = new Thread(
                () -> {
                    for ( int i = 0; i < 10000; i++ ) {
                        System.out.println("min");
                    }
                });
        Thread max = new Thread(() -> {
            for ( int i = 0; i < 10000; i++ ) {
                System.out.println("max");
            }
        });
        Thread nor = new Thread(() -> {
            for ( int i = 0; i < 10000; i++ ) {
                System.out.println("nor");
            }
        });

//        min.setPriority(1);
        min.setPriority(Thread.MIN_PRIORITY);
        max.setPriority(Thread.MAX_PRIORITY);

        min.start();
        max.start();
        nor.start();
    }
}
