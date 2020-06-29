package study.笔试;
//import java.io.InputStreamReader;
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
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

//
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int [][]people=new int[][]{{0,2},{1,3},{2,4}};
        List<int[]> list=new ArrayList<>();
        for (int []p:people) {
            list.add(p[0],p);
        }
        int [][]res=list.toArray(new int[people.length][2]);
        Queue queue=new LinkedList();
        System.out.println(queue.add(1));
        System.out.println(queue.add(2));
        System.out.println(queue.add(3));
        System.out.println(queue.offer(4));
        System.out.println("---------------");
        System.out.println();
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.element());
        System.out.println(queue.peek());
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNextInt()) {
//            int n = sc.nextInt();
//            int []res=new int[3];
//            for (int i = 0; i < n ; i++) {
//                res[i]=sc.nextInt();
//            }
//            int []res1=new int[3];
//            for (int i = 0; i < n ; i++) {
//                res1[i]=sc.nextInt();
//            }
//            int count=0;
//            for (int i = 1; i <n ; i++) {
//                if(res[i]<res[i-1]){
//                    count++;
//                }
//            }
//            System.out.println(count);
//        }
    }
}
//public class Main {
//    private Stack<Integer> push;
//    private Stack<Integer> pop;
//
//    public Main() {
//        this.pop = new Stack<Integer>();
//        this.push = new Stack<Integer>();
//    }
//
//    public void add(int newNum) {
//        this.push.push(newNum);
//        if (this.pop.empty()) {
//            while (!this.push.empty()) {
//                this.pop.push(this.push.pop());
//            }
//        }
//    }
//
//    public int poll() {
//        if (this.pop.empty() && this.push.empty()) {
//            throw new RuntimeException("Queue is empty!");
//        } else if (this.pop.empty()) {
//            while (!this.push.empty()) {
//                this.pop.push(this.push.pop());
//            }
//        }
//        return this.pop.pop();
//    }
//
//    public int peek() {
//        if (this.pop.empty() && this.push.empty()) {
//            throw new RuntimeException("Queue is empty!");
//        } else if (this.pop.empty()) {
//            while (!this.push.empty()) {
//                this.pop.push(this.push.pop());
//            }
//        }
//        return this.pop.peek();
//    }
//
//    public static void main(String[] args) throws Exception {
//        Main q = new Main();
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        for (int i = 0; i < n; i++) {
//            String[] opr = br.readLine().split(" ");
//            if (opr.length == 2) {
//                q.add(Integer.parseInt(opr[1]));
//            } else {
//                if (opr[0].equals("peek")) {
//                    System.out.println(q.peek());
//                } else q.poll();
//            }
//
//        }
//    }
//
//}


//    //    public static String [] calculate(String [] str){
////        HashMap<String,String>map=new HashMap<>();
////        for (int i = 0; i <str.length ; i++) {
////            if(str[i].contains("##")){
////                String []strings=str[i].split("##");
////                if(strings.length>1) {
////                    map.put(strings[0], map.getOrDefault(strings[0], "") + strings[1]);
////                }else {
////                    map.put(strings[0], map.getOrDefault(strings[0], "")+"*");
////                }
////            }else {
////                map.put(str[i],map.getOrDefault(str[i],"")+"$$");
////            }
////        }
////        HashMap<String,String>res=new HashMap<>();
////        for (Map.Entry entry:map.entrySet()) {
////            map.put((String) entry.getValue(),map.getOrDefault(entry.getValue(), "")+entry.getKey());
////        }
////        Collections.sort(res);
////        int i=0;
//////        for (int i = 0; i <map.size() ; i++) {
//////            visited[i]=true;
//////            for (int j = 1; j <map.size() ; j++) {
//////                if(map.get())
//////            }
//////        }
////        return null;
////    }
////    public static void main(String[] args) {
////        Scanner sc=new Scanner(System.in);
////        while (sc.hasNextInt()){
////            int r =sc.nextInt();
////            int c=sc.nextInt();
////            int [][]nums=new int[r][c];
////            for (int i = 0; i <r ; i++) {
////                for (int j = 0; j <c ; j++) {
////                    nums[i][j]=sc.nextInt();
////                }
////            }
////            System.out.println(numIslands(nums));
////        }
//////        Scanner sc = new Scanner(System.in);
//////        while (sc.hasNextLine()) {
//////            int k= Integer.parseInt(sc.nextLine().trim());
//////            HashMap<String,String>map=new HashMap<>();
//////            for (int i = 0; i <k ; i++) {
//////                String line=sc.nextLine().trim();
//////                String []str=line.split("//");
//////                if(str[1].contains("/")){
//////                    String []strings=str[1].split("/");
//////                    map.put()
//////                }
//////            }
//////        }
////    }
//    public static int numIslands(int[][] grid) {
//        int nums = 0;
//        for (int i = 0; i < grid.length; i++) {
//            replace(grid, i, 0);
//            replace(grid, i, grid[0].length - 1);
//        }
//        for (int i = 0; i < grid[0].length; i++) {
//            replace(grid, 0, i);
//            replace(grid, grid.length - 1, i);
//        }
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//                if (grid[i][j] == 1) {
//                    calculate(grid, i, j);
//                    nums++;
//                }
//            }
//        }
//        return nums;
//    }
//
//    private static int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
//
//    public static int calculate(int[][] grid, int r, int c) {
//        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0) {
//            return 0;
//        }
//        grid[r][c] = 0;
//        int res = 1;
//        for (int[] d : directions) {
//            res += calculate(grid, r + d[0], c + d[1]);
//        }
//        return res;
//    }
//
//    public static void replace(int[][] grid, int r, int c) {
//        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0) {
//            return;
//        }
//        grid[r][c] = 0;
//        for (int[] d : directions) {
//            calculate(grid, r + d[0], c + d[1]);
//        }
//    }
//}
//
//
////
////    int left = 0, right = 0, max = 0;
////            for (int i = 0; i < m; i++) {
////        a[i] = sc.nextInt();
////        left = Math.max(left, a[i]);
////        right += a[i];
////        }
////        if (m == k) {
////        for (int i = 0; i < m - 1; i++) {
////        System.out.print(a[i]+" " +"/"+" ");
////        }
////        System.out.print(a[m - 1]);
////        }else if(k==1){
////        for (int i = 0; i < m - 1; i++) {
////        System.out.print(a[i] + " ");
////        }
////        System.out.print(a[m - 1]);
////        }else
////        calculate(a, m, k, left, right);
////    public static void calculate(int[] a, int m, int k, int left, int right) {
////        int max = right;
////        int mid;
////            while (left < right) {
////                mid = (left + right) >> 1;
////                int t = 1, sum = a[0];
////                for (int i = 1; i < m; i++) {
////                    if (sum + a[i] <= mid) {
////                        sum += a[i];
////                    } else {
////                        t++;
////                        if (t > k) break;
////                        sum = a[i];
////                    }
////                }
////                if (t > k) {
////                    left = mid + 1;
////                } else {
////                    right = mid;
////                }
////            }
////        }
////        if (right != max) {
////            int sum = 0;
////            for (int i = 0; i < m; i++) {
////                if (sum + a[i] <= right) {
////                    System.out.print(a[i] + " ");
////                    sum += a[i];
////                } else {
////                    sum = 0;
////                    System.out.print("/" + " ");
////                    i--;
////                }
////            }
////        } else {
////            for (int i = 0; i < m - 1; i++) {
////                System.out.print(a[i] + " ");
////            }
////            System.out.print(a[m - 1]);
////        }
////    }
////}
////https://exam.nowcoder.com/cts/17073371/summary?id=CE8DF681247E5C46
//// 5a 12 5b ba 34 5b bb 88 05 5a 75 cd bb 62 5a 34 cd 78 cc da fb 06 5a
////public class Main {
////    public static void main(String[] args) {
////        Scanner sc = new Scanner(System.in);
////        while (sc.hasNextLine()) {
////            String str = sc.nextLine();
////            List<String> list = calculate(str);
////            int n = list.size();
////            if(n<1){
////                System.out.println("");
////            }else {
////                String res = "5a";
////                for (int i = 0; i < n; i++) {
////                    if(list.get(i)!="") {
////                        res += list.get(i) + "5a";
////                    }
////                }
////                System.out.println(res);
////            }
////        }
////    }
////
////    public static List calculate(String str) {
////        List<String> list = new ArrayList<>();
////        String[] res = str.split("5a");
////        for (int i = 1; i < res.length; i++) {
////            if (res[i].length() > 3) {
////                int size = res[i].charAt(res[i].length() - 2) - '0' + (res[i].charAt(res[i].length() - 3) - '0') * 16;
////                String temp = res[i].trim().replace("5b ba", "5a").replace("5b bb", "5b");
////                int count = 0;
////                for (int j = 0; j < temp.length(); j++) {
////                    if (temp.charAt(j) == ' ') {
////                        count++;
////                    }
////                }
////                if (count == size) {
////                    list.add(res[i]);
////                }
////            } else {
////                list.add(res[i]);
////            }
////        }
////        return list;
////    }
////}
////    ArrayList<Character> list=new ArrayList<>();
////            for (int i = 0; i <str.length() ; i++) {
////                if(str.charAt(i)>='0'&&str.charAt(i)<='9'){
////                    list.add(str.charAt(i));
////                }
////            }
////            Collections.sort(list);
////            String res="";
////            for (char c:list) {
////                res+=c;
////            }
////            System.out.println(res);
////public static void copyAllFiles(String srcPath,String desPath) throws IOException {
////        File srcfile=new File(srcPath);
////        File desFile=new File(desPath);
////        if(!srcfile.exists()){
////        System.out.println("文件不存在");
////        }
////        if(srcfile.isDirectory()){
////        File [] files=srcfile.listFiles();
////        for (int i = 0; i <files.length ; i++) {
////        String des=desPath+File.separator+files[i].getPath().replace(srcPath,"");
////        copyAllFiles(files[i].getPath(),des);
////        }
////        }else {
////        copyFile(srcfile,desFile);
////        }
////        }
////public static void copyFile(File srcFile,File desFile) throws IOException {
////        if(!desFile.getParentFile().exists()){
////        desFile.getParentFile().mkdirs();
////        }
////        FileInputStream in=new FileInputStream(srcFile);
////        FileOutputStream out=new FileOutputStream(desFile);
////        byte[] buf=new byte[1024];
////        int len=0;
////        while ((in.read(buf))!=-1){
////        out.write(buf,0,len);
////        }
////        in.close();
////        out.close();
////        }
//
//
