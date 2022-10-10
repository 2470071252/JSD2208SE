package exception;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * JDK7之后java推出了自动关闭特性
 * 可以用更简洁的语法完成如IO操作的异常处理中关闭的问题
 */
public class AutocloseableDemo {
    public static void main(String[] args) {
        // 下面代码经过编译之后，和FinallyDemo2编译的class文件中的代码相同
        try (
                // 只有实现了java.io.AutoCloseable接口的实例才能放入(比如所有的流)
                // 编译器会将在这里定义的的类最终在finally中调用close关闭
                // 注： 所有的流都实现了AutoCloseable接口，并且closeable接口继承了Autocloseable接口
                FileOutputStream fos = new FileOutputStream("fos.dat");
        ) {
            fos.write(1);
        } catch (IOException e) {
            System.out.println("Error!");
        }
    }
}
