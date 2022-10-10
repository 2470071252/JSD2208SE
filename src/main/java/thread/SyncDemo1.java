package thread;

/**
 * 多线程并发安全问题
 * 当多个线程并发操作同一临界资源，由于操作顺序不确定，导致操作结果出现混乱
 * 从而出现不良后果。
 * 临界资源：操作该资源的完整过程中同一时刻只能被单一线程进行
 */
public class SyncDemo1 {
    public static void main(String[] args) {
        Table table = new Table();
        Thread thread = new Thread(){
            @Override
            public void run() {
                while (true){
                    int bean = table.getBean();
                    Thread.yield();
                    System.out.println(getName()+":"+bean);
                }
            }
        };

        Thread thread1 = new Thread(){
            @Override
            public void run() {
                while (true){
                    int bean = table.getBean();
                    Thread.yield();
                    System.out.println(getName()+":"+bean);
                }
            }
        };

        thread.start();
        thread1.start();
    }
}
class Table{
    private int beans = 20; // 桌子上有20个豆子

    public int getBean(){
        if (beans==0){
            throw new RuntimeException("没有豆子了！");
        }
        Thread.yield();
        return beans--;
    }
}
