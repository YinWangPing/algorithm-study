package 笔试;

import java.io.InputStream;
import java.util.*;

public class test {

    public static void main(String[] args) {
        List<String> lines = new ArrayList<>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);
            while (scanner.hasNextLine()) {
                int n= Integer.parseInt(scanner.nextLine().trim());
                for (int i = 0; i <n ; i++) {
                    lines.add(scanner.nextLine());
                }
//                ArrayList<Integer>res=cal(lines,n);
            }
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
        System.out.println();
    }

    static class ListNode {
        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
//    private static ArrayList cal(List<String> lines,int n){
//        int []nums=new int[n];
//        fori
//    }
    private static ListNode mergeNodes(ListNode head) {
        return head;
    }


}
