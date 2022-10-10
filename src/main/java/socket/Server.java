package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

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
    public Server() {
        try {
            System.out.println("Server Starting......");
            serverSocket = new ServerSocket(8000);
            System.out.println("Successfully！");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void start(){
        try {
            while (true){
                System.out.println("Wait client connection!");
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
    private class ClientHandler implements Runnable{
        private Socket socket;
        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // 通过socket获取输入流读取自远端计算机发送过来的数据
                InputStream in = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(in, StandardCharsets.UTF_8);
                BufferedReader br = new BufferedReader(isr);
                // 读取一行来自远端计算机发送过来的字符串
                String fromClientMessages;
                while ((fromClientMessages =br.readLine())!=null){
                    System.out.println("来自客户端"+socket.getInetAddress()+"的消息： "+fromClientMessages);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
