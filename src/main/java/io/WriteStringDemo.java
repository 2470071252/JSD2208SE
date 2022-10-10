package io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class WriteStringDemo {
    public static void main(String[] args) throws IOException {
        // 向文件fos.txt文件中吸入文本数据
        FileOutputStream fos = new FileOutputStream("fos.txt",true);
        // new FileOutputStream(文件名,是否开启追加模式)
        /*
        字符集：
        字符集想象为一个大表格，在上面定义了每个文字对应的2进制的样子
        GBK：我国的国标编码
            汉字每个字符占2个字节，英文字母每个字符占1个字节。
        UTF-8：UNICODE的传输编码(万国码)，互联网上最常使用的字符集
                该字符集支持所有国家的文字
            英文占1个字节，中文占3个字节
         */
        // 字符串转字节
        /*
        String字符串提供了将字符串转换为一组字节的方法：
            byte[] getBytes(StandardCharsets.UTF_8);
            该方法可以将当前字符串按照UTF-8编码字符转换为一组字符
         */
        String line = "大噶杀了咯岁的凯莉开挂";
        byte[] data = line.getBytes(StandardCharsets.UTF_8);
        fos.write(data);
        line = "\n范德萨离开；回复撒旦克里夫萨迪克来；阿斯顿";
        data = line.getBytes(StandardCharsets.UTF_8);
        fos.write(data);
        fos.close();
    }
}
