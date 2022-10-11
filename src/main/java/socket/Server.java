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
    private List<Socket> allSocket = new ArrayList<>();


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

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // 通过socket获取输入流读取自远端计算机发送过来的数据
                InputStream in = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(in, UTF_8);
                BufferedReader br = new BufferedReader(isr);

                // 通过socket获取输出流，用来将消息发发送给（远端计算机）客户端
                OutputStream os = socket.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(os, UTF_8);
                BufferedWriter bw = new BufferedWriter(osw);
                PrintWriter pw = new PrintWriter(bw, true);
                // 将该输出流存入共享集合
                allOut.add(pw);
                allSocket.add(socket);

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
                    System.out.println("来自客户端" + socket.getInetAddress() + "的消息： " + fromClientMessages);
                    // 将消息广播给所有客户端
                    /*
                    for ( PrintWriter o : allOut ) {
                        o.println("客户端说：" + fromClientMessages);
                    }
                    */
                    for ( PrintWriter o : allOut ) {
//                        o.println("客户端说："+fromClientMessages);
                        for ( Socket so : allSocket ) {
                            o.println("来自客户端"+so.getInetAddress()+"的消息： "+fromClientMessages);
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
