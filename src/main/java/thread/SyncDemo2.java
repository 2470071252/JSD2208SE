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

    }
}

class shop{
    public void buy(){

        System.out.println("");
    }
}
