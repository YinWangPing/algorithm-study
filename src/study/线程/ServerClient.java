package study.线程;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/3/9 17:09
 */

public class ServerClient {
    public static void main(String[] args) throws IOException {
        ServerSocket server=new ServerSocket(9999);
        System.out.println("等待客户端连接...");
        Socket socket=server.accept();
        Scanner input=new Scanner(socket.getInputStream());
        PrintStream out=new PrintStream(socket.getOutputStream());
        Boolean flag=true;
        while(flag){
            if(input.hasNextLine()){
                String str=input.nextLine();
                System.out.println("获取客户端数据:"+str);
                if ("end".equalsIgnoreCase(str)) {
                    flag=false;
                }
                out.println("Echo"+str);
            }
        }
        out.close();
        input.close();
        socket.close();
        server.close();
    }
}
