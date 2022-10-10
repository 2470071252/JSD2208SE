package thread;

/**
 * 线程提供了一组获取当前线程相关信息方法
 */
public class ThreadInfoDemo {
    public static void main(String[] args) {
        // 得到主线程
        Thread main = Thread.currentThread();
        // 获取线程的名字
        String name = main.getName();
        System.out.println("名字"+name);
        // 获取线程的唯一标识，（非空且唯一），主线程的id一般为1
        long id = main.getId();
        System.out.println("唯一标识："+id);
        // 获取线程的优先级（1-10）
        int priority = main.getPriority();
        System.out.println("优先级："+priority);
        System.out.println("--------------------------------------------");

        boolean isAlive = main.isAlive();     // 线程是否存活
        boolean isDaemon = main.isDaemon();    // 是否为守护线程
        boolean isInterrupted = main.isInterrupted();   // 是否被中断
        System.out.println(isAlive);
        System.out.println(isDaemon);
        System.out.println(isInterrupted);
        System.out.println("-----------------------------------------");




    }
}
