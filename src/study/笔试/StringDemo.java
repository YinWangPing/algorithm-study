package study.笔试;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/4/28 16:39
 */

public class StringDemo {
    public static void main(String[] args) {
        int x=21,y=8;
        System.out.println(x%=y/=2);
        List<Integer>list=new ArrayList<>();
        list.add(0);
        list.add(0);
        list.add(0);
        list.add(1);
        list.add(3);
        list.add(5);
        list.add(0);
        list.add(4);
        list.add(0);
        for (int i = 0; i < list.size(); i++) {
            list.remove(i);
        }
        System.out.println(list);

//        System.out.println(calculate1("abcbceg","bce"));
//        int [][]nums=new int[][]{{1,1,0},
// {1,1,0},
// {0,1,1}};
//        System.out.println(findCircleNum(nums));
//        List<List<Character>>res=calculate("abcd");
//        for (List<Character> list:res) {
//            System.out.println(list);
//        }
    }
    static int [][] directions=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public static int findCircleNum(int[][] nums) {
        int count=0;
        for (int i = 0; i <nums.length ; i++) {
            for (int j = 0; j <nums[0].length ; j++) {
                if(nums[i][j]==1){
                    dfs(nums,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    public static void dfs(int [][]nums,int r,int c){
        if(r<0||r>=nums.length||c<0||c>=nums[0].length||nums[r][c]==0){
            return;
        }
        nums[r][c]=0;
        for (int [] d:directions) {
            dfs(nums,r+d[0],c+d[1]);
        }
    }
    private static boolean calculate1(String stra, String strb) {
        if (stra.length() < strb.length()) {
            String temp=stra;
            stra=strb;
            strb=temp;
        }
        int count=0;
        for (int i = 0; i < stra.length(); i++) {
            count=0;
            for (int j = 0; j <strb.length() ; j++) {
                if(stra.charAt(i+j) == strb.charAt(j)){
                    count++;
                } else {
                    break;
                }
            }
            if (count == strb.length()) {
                System.out.println(i);
                return true;
            }
        }
        return false;
    }
    public static List<List<Character>>calculate(String str){
        List<List<Character>>res=new ArrayList<>();
        if(str==null||str.length()==0){
            return res;
        }
        boolean visited[]=new boolean[str.length()];
        List<Character> list=new ArrayList<>();
        backTracking(res,list,visited,str);
        return res;
    }
    public static void backTracking(List<List<Character>> res, List<Character> list, boolean visited[], String str){
        if(list.size()==str.length()){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i <str.length() ; i++) {
            if(visited[i]){
                continue;
            }
            visited[i]=true;
            list.add(str.charAt(i));
            backTracking(res,list,visited,str);
            list.remove(list.size()-1);
            visited[i]=false;
        }
    }
    private static boolean calculate(String stra, String strb) {
        if (stra.length() < strb.length()) {
            String temp=stra;
            stra=strb;
            strb=temp;
        }
        int count = 0;

        for (int i = 0; i < strb.length(); i++) {
            for (int j = 0; j < stra.length(); j++) {
                if (stra.charAt(j) == strb.charAt(j)) {
                    count++;
                    break;
                }
            }
        }
        if (count == strb.length()) {
            return true;
        } else {
            return false;
        }
    }
}
