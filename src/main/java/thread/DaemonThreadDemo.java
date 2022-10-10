package thread;

/**
 * 守护线程
 * 守护线程也称为后台线程
 * 我们正常创建的线程都称为"用户线程，也可称为普通线程，前台线程
 * 守护线程是通过调用线程的setDaemon(true)而转变为守护线程的
 *
 * 守护线程与用户线程的区别：
 * 当一个java进程中的所有用户线程都结束时，进程就会结束，此时进程会强制杀死
 * 所有还在运行的守护线程。
 */
public class DaemonThreadDemo {
    public static void main(String[] args) {
        Thread rose= new Thread(){
            @Override
            public void run() {
                for ( int i = 0; i < 5; i++ ) {
                    System.out.println("Let me go!");
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("aaaaaaaAAAAAAAAAAA");
                System.out.println("噗通");
            }
        };

        Thread jack = new Thread() {
            @Override
            public void run() {
                while (true){
                    System.out.println("You jump, i jump!");
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        rose.start();
        // 设置某个线程为守护线程，必须在该线程启动之前，
        jack.setDaemon(true);
        jack.start();

        // 主线程也是用户进程，如果主线程不结束，进程就不会结束(因为还有用户线程)
//        while (true);
    }
}
