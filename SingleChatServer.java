package SingleChatRoom;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SingleChatServer {
    public static void main(String[] args){
        ServerSocket serverSocket = null;
        try {

            //建立一个服务器
            serverSocket = new ServerSocket(6666);
            //等待客户端连接
            System.out.println("正在等待客户端连接");
            //服务器端线程一直阻塞，直到有客户端连接，返回客户端连接的socket
            Socket client = serverSocket.accept();
            System.out.println("客户端已连接，其端口号为" + client.getPort());
            //获取客户端输出流，将消息发送至服务器端
            PrintStream out = new PrintStream(client.getOutputStream(),true,"UTF-8");
            Scanner scanner = new Scanner(client.getInputStream());

            if(scanner.hasNextLine()){
                System.out.println(scanner.nextLine());
            }
            out.print("I am server!!!");

            scanner.close();
            out.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
