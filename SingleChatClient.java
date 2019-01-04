package SingleChatRoom;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SingleChatClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1",6666);
            System.out.println("已开启客户端");

            PrintStream out = new PrintStream(socket.getOutputStream());
            out.println("I am client!!!");

            Scanner scanner = new Scanner(socket.getInputStream());

            while(scanner.hasNextLine()){
                System.out.println(scanner.nextLine());
            }

            out.close();
            scanner.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
