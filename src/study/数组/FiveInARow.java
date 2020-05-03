package study.数组;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/3/20 17:20
 */

public class FiveInARow {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        ArrayList<String> list=new ArrayList();
        while (scanner.hasNext()){
            String str=scanner.next();
            if(scanner.nextLine().equals("")){
                System.out.println(check(list));
            }
            list.add(str);
        }
//        Scanner scanner=new Scanner(System.in);
//        ArrayList<String> list=new ArrayList();
////        while (scanner.hasNext()){
////            String str=scanner.next();
////            list.add(str);
////        }
//        for (int i = 0; i <6 ; i++) {
//            list.add(scanner.nextLine());
//        }
//        System.out.println(check(list));
    }
    public static String check(ArrayList<String> list){
        String str="No";
        int row=list.size();
        int col=list.get(0).length();
        for (int i = 0; i <row ; i++) {
            for (int j = 0; j <col ; j++) {
                if(list.get(i).charAt(j)=='*'||list.get(i).charAt(j)=='+'){
                    if(i<=list.size()-5&&list.get(i).charAt(j)==list.get(i+1).charAt(j)&&list.get(i).charAt(j)==list.get(i+2).charAt(j)
                            &&list.get(i).charAt(j)==list.get(i+3).charAt(j)&&list.get(i).charAt(j)==list.get(i+4).charAt(j)){
                        return "Yes";
                    }
                    if(j<=list.get(0).length()-5&&list.get(i).charAt(j)==list.get(i).charAt(j+1)&&list.get(i).charAt(j)==list.get(i).charAt(j+2)
                            &&list.get(i).charAt(j)==list.get(i).charAt(j+3)&&list.get(i).charAt(j)==list.get(i).charAt(j+4)){
                        return "Yes";
                    }
                    if(i<=list.size()-5&&j<=list.get(0).length()-5&&list.get(i).charAt(j)==list.get(i+1).charAt(j+1)&&list.get(i).charAt(j)==list.get(i+2).charAt(j+2)
                            &&list.get(i).charAt(j)==list.get(i+3).charAt(j+3)&&list.get(i).charAt(j)==list.get(i+4).charAt(j+4)){
                        return "Yes";
                    }
                }
            }
        }
        return str;
    }
}
