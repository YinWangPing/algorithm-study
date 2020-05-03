package study.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/4/4 20:44
 */

public class Permute {
    public static void main(String[] args) {
        int[]nums=new int[]{1,2,3,4};
        List<List<Integer>> res=permute1(nums);
        for (int i = 0; i <res.size() ; i++) {
            for (int j = 0; j <res.get(i).size() ; j++) {
                System.out.print(res.get(i).get(j)+"\t");
            }
            System.out.println();
        }
    }
    //------------------------------------------------------------------------------------------------------
    /**
     *给定一个 没有重复 数字的序列，返回其所有可能的全排列。1,2,3
     */
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        int []visited=new int[nums.length];
        backTrack(nums,new ArrayList(),visited,res);
        return res;
    }
    public static void backTrack(int []nums,ArrayList list,int []visited,List<List<Integer>> res){
        if(list.size()==nums.length){
            res.add(new ArrayList<>(list));
        }
        for (int i = 0; i <nums.length ; i++) {
            if(visited[i]==1){
                continue;
            }
            visited[i]=1;
            list.add(nums[i]);
            backTrack(nums,list,visited,res);
            visited[i]=0;
            list.remove(list.size()-1);
        }
    }
    //------------------------------------------------------------------------------------------------------
    /**
     *给定一个有重复数字的序列，返回其所有可能的全排列。1,1,2
     */
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        int []visited=new int[nums.length];
        backTrackUnique(nums,new ArrayList(),visited,res);
        return res;
    }
    public static void backTrackUnique(int []nums,ArrayList list,int []visited,List<List<Integer>> res){
        if(list.size()==nums.length){
            res.add(new ArrayList<>(list));
        }
        for (int i = 0; i <nums.length ; i++) {
            if(visited[i]==1){
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1]==0) {//剪枝，减去上次被访问过的并且不在使用的相同的节点
                continue;
            }
            visited[i]=1;
            list.add(nums[i]);
            backTrackUnique(nums,list,visited,res);
            visited[i]=0;
            list.remove(list.size()-1);
        }
    }
    //--------------------------
    public static List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>>res=new ArrayList<>();
        int []visited=new int[nums.length];
        backTrack1(nums,visited,new ArrayList<>(),res);
        return res;
    }
    public static void backTrack1(int []nums,int []visited,List<Integer> list,List<List<Integer>> res){
        if(list.size()==nums.length){
            res.add(new ArrayList<>(list));
        }
        for (int i = 0; i <nums.length ; i++) {
            if(visited[i]==1){
                continue;
            }
            visited[i]=1;
            list.add(nums[i]);
            backTrack1(nums,visited,list,res);
            visited[i]=0;
            list.remove(list.size()-1);
        }
    }
}
