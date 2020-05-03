package study.测试;

import java.util.Scanner;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/3/26 18:08
 */

public class test1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNextLine()){
            String str=scanner.nextLine().trim();
            System.out.println(calculate(str));
        }
    }
    public static int calculate(String str){
        String [] strings=str.split(" ");
        int max=0,min = Integer.parseInt(strings[0]);
        for(int i = 1; i < strings.length; i++) {
            max = Math.max(max, Integer.parseInt(strings[i]) - min);
            min = Math.min(min, Integer.parseInt(strings[i]));
        }
        return max;
    }
}
