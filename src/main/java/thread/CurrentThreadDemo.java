package thread;

/**
 * java程序中所有的代码都是靠线程执行的，main方法也不例外
 * 执行main方法的线程是虚拟机自动创建的，并为线程取了个名字叫"main"，因此
 * 我们也称执行main方法的线程为主线程
 */
public class CurrentThreadDemo {
    public static void main(String[] args) {
        Thread main = Thread.currentThread();
        System.out.println(main);
        dosome();
        // 当main方法执行完毕，主线程的任务就结束了，主线程也就结束了
    }
    public static void dosome(){
        Thread t = Thread.currentThread();
        System.out.println(t);
    }
}
