package file;

import java.io.File;

/**
 * java.io.File
 * File的每一个实例用于表示硬盘上的一个文件或目录（实际上是一个抽象路径）
 * 使用File我们可以：
 * 1.访问文件或目录的属性
 * 2.创建或删除文件或目录
 * 3.访问一个目录中的子项
 *
 * 但是不能访问File访问文件内容
 */
public class FileDemo {
    public static void main(String[] args) {
        File file = new File("./demo.txt");
        String name = file.getName();
        System.out.println("名字：" + name);

        long length = file.length(); //文件字节数
        System.out.println("长度：" + length+"字节");

        boolean cr = file.canRead();
        boolean cw = file.canWrite();
        boolean ce = file.canExecute();
        System.out.println(cr+","+cw+","+ce);
        boolean ih = file.isHidden();  // 隐藏
        System.out.println("是否隐藏" + ih);

    }
}
