package 笔试;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNextInt()){
            int k=scanner.nextInt();
            int n=scanner.nextInt();
            int x= (int) Math.sqrt(n);
            for (int i = x; i <x+4 ; i++) {
                if(i*(i+1)>=2*n){
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}