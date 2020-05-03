package study.线程;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/3/9 17:34
 */

public class Client {
    public static void main(String[] args) throws IOException {
        Socket client=new Socket("localhost",9999);
        Scanner scanner=new Scanner(System.in);
        Scanner input=new Scanner(client.getInputStream());
        PrintStream out=new PrintStream(client.getOutputStream());
        boolean flag=true;
        while (flag){
            System.out.println("请输入数据:");
            if(scanner.hasNextLine()){
                String str=scanner.nextLine();
                out.println(str);
                if("end".equalsIgnoreCase(str)){
                    flag=false;
                }
                if(input.hasNextLine()){
                    System.out.println("获取服务端返回数据:"+input.nextLine());
                }
            }
        }
        out.close();
        input.close();
        scanner.close();
        client.close();
    }
}
