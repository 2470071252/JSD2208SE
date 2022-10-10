package thread;

import java.util.Scanner;

/**
 * Sleep阻塞
 * 线程提供了一个静态方法
 * static void sleep(long ms)
 * 该方法可以让运行这个方法的线程处于阻塞状态执行毫秒，超时后线程会自动回到
 * RUNNABLE状态并再次开始并发执行
 */
public class SleepDemo {
    public static void main(String[] args) {
        /*
            倒计时程序
            在控制台上输入一个数字，从该数字开始每秒递减，到0时输出时间到
         */
        System.out.println("程序开始了");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入倒计时数字：");
        int number = scanner.nextInt();
        for ( int i =number; i >0 ; i-- ) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("倒计时结束了！");
        /*
        System.out.println(number);
        while ((number = number - 1) != 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(number);

        }
        System.out.println("倒计时结束了！");
        */

        /*
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("程序结束了");
        */
    }
}
