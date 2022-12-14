package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import static java.nio.charset.StandardCharsets.*;

/**
 * 聊天室服务端
 */
public class Server {
    /**
     * java.net.ServerSocket
     * 运行在服务端的ServerSocket主要任务：
     * 1.打开服务端口
     * 2.侦听端口，等待客户端连接
     */
    private ServerSocket serverSocket;
    // 用来保存所有客户端的输出流
    private List<PrintWriter> allOut = new ArrayList<>();

    public Server() {
        try {
            System.out.println("Server Starting......");
            serverSocket = new ServerSocket(8000);
            System.out.println("Successfully！");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void start() {
        try {
            while (true) {
                Socket socket = serverSocket.accept(); // serverSocket.accept()的返回值是Socket类型
                System.out.println("A client connected.");
                // 启动一个线程来处理与该客户端的交互
                ClientHandler clientHandler = new ClientHandler(socket);
                Thread thread = new Thread(clientHandler);
                thread.start();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }

    /**
     * 该线程任务负责与指定的客户端交互
     */
    private class ClientHandler implements Runnable {
        private Socket socket;
        private String host; // 记录客户端的IP地址

        public ClientHandler(Socket socket) {
            this.socket = socket;
            // 通过socket获取远端计算机的地址信息(IP地址)
            host = socket.getInetAddress().getHostAddress();
        }

        @Override
        public void run() {
            PrintWriter pw = null;
            try(
                    // 通过socket获取输入流读取自远端计算机发送过来的数据
                    InputStream in = socket.getInputStream();
                    ){

                InputStreamReader isr = new InputStreamReader(in, UTF_8);
                BufferedReader br = new BufferedReader(isr);

                // 通过socket获取输出流，用来将消息发发送给（远端计算机）客户端
                OutputStream os = socket.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(os, UTF_8);
                BufferedWriter bw = new BufferedWriter(osw);
                pw = new PrintWriter(bw, true);
                // 将该输出流存入共享集合
                // 将临界资源作为同步监视器对象
                // synchronized 同步监视器对象第一原则：抢谁锁谁
                synchronized (allOut){
                    allOut.add(pw);
                }
                sendMessage(host + "上线了，当前在线人数：" + allOut.size());

                // 读取一行来自远端计算机发送过来的字符串
                String fromClientMessages;
                /*
                当我调用br.readLine()读取来自远端计算机发送过来的一行字符串时，
                远端计算机如果调用了socket.close()正常与我们断开连接，那么
                readLine()方法会返回null.
                如果客户端是异常中断(比如强制杀死进程)，这里readLine()方法会
                抛出异常：java.net.SocketException: Connection reset
                 */
                while ((fromClientMessages = br.readLine()) != null) {
                    System.out.println("来自客户端" + host + "的消息： " + fromClientMessages);
                    // 将消息广播给所有客户端
                    sendMessage("来自客户端" + host + "的消息： " + fromClientMessages);
                }
            } catch (IOException e) {

            } finally {
                // 处理客户端断开连接后的操作
                // 从allOut中将该客户端的输出流删除
                synchronized (allOut){
                    allOut.remove(pw);
                }
                // 广播下线通知
                sendMessage(host+"下线了，当前在线人数："+allOut.size());
            }
        }
    }

    // 将消息广播给所有客户端
    private void sendMessage(String message) {
        synchronized (allOut){
            for ( PrintWriter o : allOut ) {
                o.println(message);
            }
        }
    }
}
