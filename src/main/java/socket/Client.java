package socket;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * 聊天室客户端
 */
public class Client {
    /*
    java.net.Socket 套接字
    Socket封装了TCP协议的连接过程及通讯过程，我们使用它就可以与
    远端计算机建立连接并基于两条流的IO操作完成与服务端的数据交互
     */
    private Socket socket;
    public Client() {
        /*
        实例化Socket时就是与服务端建立连接的过程，这里需要传入两个参数
        参数1；IP地址
        参数2: 端口
         */
        try {
            System.out.println("Loading......");
            socket = new Socket("127.0.0.1", 8000);
            System.out.println("successfully！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start(){
        try {
            // 低级流，作用：将写出的字节发送给建立连接的远端计算机
            OutputStream out = socket.getOutputStream();
            // 转换流(高级流)，作用1.衔接字节流与字符流 2.将写出的字符转换为字节
            OutputStreamWriter osw = new OutputStreamWriter(out, StandardCharsets.UTF_8);
            // 缓冲流(高级流)，作用：块写文本数据加速
            BufferedWriter bw = new BufferedWriter(osw);
            // PrintWriter(高级流)， 作用：1.按行写出字符串 2.自动刷新
            PrintWriter pw = new PrintWriter(bw,true);
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入文字：");
            while (true){
                String message = scanner.nextLine();
                if ("exit".equals(message.toLowerCase())) {
                    break;
                }
                pw.println(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Client client = new Client();
        client.start();
    }
}
