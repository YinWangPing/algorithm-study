import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/3/20 9:31
 */

public class StringDemo {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        ArrayList<String>list=new ArrayList<>();
        int n= Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n ; i++) {
            list.add(scanner.nextLine());
        }
        System.out.println(calculate(list));
    }
    public static int calculate(ArrayList<String> list){
        Collections.sort(list);
        int len=list.size(),count=0;
        ArrayList<Integer> arrayList=new ArrayList<>();
        String res="";
        for (int i = 0; i <len ; i++) {
            for (int k = 0; k <len ; k++) {
                res=list.get(i);
                count=0;
                count=list.get(i).length();
                for (int j = k + 1; j < len; j++) {
                    if (res.charAt(res.length() - 1) < list.get(j).charAt(0)) {
                        res += list.get(j);
                        count += list.get(j).length();
                    }
                }
                arrayList.add(count);
            }
        }
        Collections.sort(arrayList);
        return arrayList.get(arrayList.size()-1);
    }
}
