package study.笔试;

import com.sun.javafx.collections.MappingChange;

import java.util.*;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/4/11 18:48
 */
//public class Main {
//    static int count=0;
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        while (sc.hasNextInt()) {
//            int n = sc.nextInt();
//            int mid = sc.nextInt();
//            Vector<Integer>deque=new Vector<>();
//            for (int i = 0; i <n ; i++) {
//                deque.add(sc.nextInt());
//            }
//            System.out.println(f(deque,mid,n));
//        }
//    }
//    public static int f(Vector<Integer>deque,int mid,int n){
//        if(!deque.contains(mid)){
//            deque.add(mid);
//            if(mid==deque.get((deque.size()+1)/2-1)){
//                deque.add(mid+1);
//                count++;
//                return count;
//            }
//
//        }
//        while (mid!=deque.get((n+1)/2)){
//            if(mid>deque.get((n+1)/2)){
//                deque.add(mid+1);
//            }else {
//                deque.add(mid-1);
//            }
//            Collections.sort(deque);
//            count++;
//        }
//        return count;
//    }
//}


public class 美团 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNextLine()) {
//            String line1 = sc.nextLine();
//            String[] poi = line1.trim().split(" ");
//            long n = Long.valueOf(poi[0]), k = Long.valueOf(poi[1]);
//            if (k > n * n) {
//                System.out.println();
//                continue;
//            }
//            String line2 = sc.nextLine();
//            String[] str = line2.trim().split(" ");
//            List<Long> list = new ArrayList<>();
//            for (int i = 0; i < n; i++) {
//                long x = Integer.valueOf(str[i]);
//                if (!list.contains(x)) {
//                    list.add(x);
//                }
//            }
//            Collections.sort(list);
//            if (k > list.size() * list.size()) {
//                System.out.println("(,)");
//            }
//            int x = (int) ((k - 1) / list.size()), y = (int) ((k - 1) % list.size() + 1);
//            System.out.println("(" + list.get(x) + "," + y + ")");
//        }
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            if(n==0){
                System.out.println("");
                continue;
            }
            List<Integer>list=new ArrayList<>();
            for (int i = 0; i <n ; i++) {
                int x=sc.nextInt();
                    list.add(x);
            }
            Collections.sort(list);
            String []res=new String[n*n];
            int count=0;
            for (int i = 0; i <n ; i++) {
                for (int j = 0; j <n ; j++) {
                    res[count++]=list.get(i)+" "+list.get(j);
                }
            }
            Arrays.sort(res);
            String []fres=res[k-1].split(" ");
            System.out.println("("+fres[0]+","+fres[1]+")");
        }
    }
}


//public class Main {
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        while (sc.hasNextInt()){
//            int a=sc.nextInt();
//            int b=sc.nextInt();
//            int m=sc.nextInt();
//            int x=sc.nextInt();
//            System.out.println(f(a,b,m,x));
////            int count=0;
////            HashSet<Integer>set=new HashSet<>();
////            set.add(x);
////            while (true){
////                x=(a*x+b)%m;
////                count++;
////                if(set.contains(x)&&set.contains((a*x+b)%m)){
////                    break;
////                }
////            }
////            System.out.println(count);
//        }
//    }
//    public static int f(int a,int b,int m,int x){
//        x=(a*x+b)%m;
//        Vector v=new Vector();
//        for (;;) {
//            v.add(x);
//            x=(a*x+b)%m;
//            if(v.indexOf(x)>=0){
//                return v.size()-v.indexOf(x);
//            }
//        }
//    }
//
//}
//    Scanner sc=new Scanner(System.in);
//        while (sc.hasNextInt()){
//                int a=sc.nextInt();
//                int b=sc.nextInt();
//                int m=sc.nextInt();
//                int x=sc.nextInt();
//                int count=0;
//                HashSet<Integer>set=new HashSet<>();
//        set.add(x);
//        while (true){
//        x=(a*x+b)%m;
//        count++;
//        if(set.contains(x)&&set.contains((a*x+b)%m)){
//        break;
//        }
//        }
//        System.out.println(count);
//        }
//{
//        int n=sc.nextInt();
//        int m=sc.nextInt();
//        int [][]nums=new int[n][m];
//        int []max=new int[m];
//        int count=0;
//        for (int i = 0; i <n ; i++) {
//        for (int j = 0; j <m ; j++) {
//        nums[i][j]=sc.nextInt();
//        max[j]=Math.max(nums[i][j],max[j]);
//        }
//        }
//        HashSet<Integer>set=new HashSet<>();
//        for (int i = 0; i <m ; i++) {
//        for (int j = 0; j <n ; j++) {
//        if(nums[j][i]==max[i]){
//        set.add(j);
//        }
//        }
//        }
//        System.out.println(set.size());
//        }
