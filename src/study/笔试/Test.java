package study.笔试;

import java.util.Scanner;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/4/26 20:26
 */
//class Myqueue {
//    private LinkedList list;
//
//    public Myqueue() {
//        this.list = new LinkedList();
//    }
//
//    public void add(Object obj) {
//        list.add(obj);
//    }
//
//    public Object get() {
//        return list.removeLast();
//    }
//
//    public boolean isNull() {
//        return list.isEmpty();
//    }
//}
//
//public class Test {
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
////        Scanner sc = new Scanner(System.in);
////        while (sc.hasNextLine()) {
//        int k = Integer.parseInt(br.readLine().trim());
//        for (int i = 0; i < k; i++) {
//            int x = Integer.parseInt(br.readLine().trim());
//            Queue<Integer> queue = new PriorityQueue<>();
//            for (int j = 0; j < x; j++) {
//                String line = br.readLine().trim();
//                if (line.contains("PUSH")) {
//                    String[] str = line.split(" ");
//                    queue.add(Integer.valueOf(str[1]));
//                } else if (line.contains("TOP")) {
//                    String pk = String.valueOf(queue.peek());
//                    if (!pk.equals("null")) {
//                        System.out.println(pk);
//                    } else {
//                        System.out.println(-1);
//                    }
//                } else if (line.contains("POP")) {
//                    String pk = String.valueOf(queue.poll());
//                    if (pk.equals("null")) {
//                        System.out.println(-1);
//                    }
//                } else if (line.contains("SIZE")) {
//                    System.out.println(queue.size());
//                } else if (line.contains("CLEAR")) {
//                    queue.clear();
//                }
//            }
//        }
//    }
//
////        queue.add(1);
////        queue.add(2);
////        System.out.println(queue.peek());//top
////        System.out.println(queue.poll());//pop
////        System.out.println(queue.peek());//top
////        System.out.println(queue.poll());//pop
////        System.out.println(queue.poll());//pop
////        System.out.println(queue.peek());//pop
////        Scanner sc = new Scanner(System.in);
////        while (sc.hasNextLine()) {
////            int k= Integer.parseInt(sc.nextLine().trim());
////            for (int i = 0; i <k ; i++) {
////                int x= Integer.parseInt(sc.nextLine().trim());
////
////            }
////        }
//
//}
//import java.io.BufferedReader;
//        import java.io.InputStreamReader;
//
//public class Main{
//    public static void main(String[] args) throws  Exception{
//        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//        int n=Integer.parseInt(br.readLine());
//        for(int i=0;i<n;i++){
//            String[] f=br.readLine().split(" ");
//            String tempi=Integer.toBinaryString(Integer.parseInt(f[0]));
//            int indexj=-1;
//            for(int j=0;j<tempi.length();j++){
//                if(tempi.charAt(j)=='1'){
//                    indexj=j;
//                    break;
//                }
//            }
//            int level=tempi.length()-indexj;
//            long res=-1;
//            long nums= Long.parseLong(f[0]);
//            for(int p=0;p<level-Integer.parseInt(f[1]);p++){
//                res=nums/2;
//                nums=res;
//            }
//            System.out.println(res);
//        }
//    }
//}

//public class Test {
//    public static void main(String[] args) {
////        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNextLine()) {
//            int n = Integer.parseInt(sc.nextLine().trim());
//            for (int i = 0; i < n; i++) {
//                String[] strings = sc.nextLine().trim().split(" ");
//                String indexi = Integer.toBinaryString(Integer.parseInt(strings[0]));
//                int indexj = -1;
//                for (int j = 0; j < indexi.length(); j++) {
//                    if (indexi.charAt(j) == '1') {
//                        indexj = j;
//                        break;
//                    }
//                }
//                int level = indexi.length() - indexj;
//                long res = -1;
//                long nums = Long.parseLong(strings[0]);
//                for (int p = 0; p < level - Integer.parseInt(strings[1]); p++) {
//                    res = nums / 2;
//                    nums = res;
//                }
//                System.out.println(res);
//            }
//        }
//    }
//}
import java.util.ArrayList;
import java.util.List;

class point{
    int x;
    int y;
}
public class Test {

//    static class point {
//        int x;
//        int y;
//    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int t = Integer.parseInt(sc.nextLine().trim());
            while (t > 0) {
                int n = Integer.parseInt(sc.nextLine().trim());
                List<point> A = new ArrayList<>();
                List<point> B = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    point p = new point();
                    String[] opr = sc.nextLine().trim().split(" ");
                    p.x = Integer.parseInt(opr[0]);
                    p.y = Integer.parseInt(opr[1]);
                    A.add(p);
                }
                for (int i = 0; i < n; i++) {
                    point p = new point();
                    String[] opr = sc.nextLine().trim().split(" ");
                    p.x = Integer.parseInt(opr[0]);
                    p.y = Integer.parseInt(opr[1]);
                    B.add(p);
                }
                double mindis = Integer.MAX_VALUE;
                for (point p : A) {
                    for (point p1 : B) {
                        mindis = Math.min(mindis, Math.sqrt(Math.pow((p.x - p1.x), 2) + Math.pow((p.y - p1.y), 2)));
                    }
                }
                String doublestr = String.format("%.3f", mindis);
                System.out.println(doublestr);
                t--;
            }
        }
    }
}
