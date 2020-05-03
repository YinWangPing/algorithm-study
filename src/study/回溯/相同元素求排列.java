package study.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/4/28 22:28
 */

public class 相同元素求排列 {
    public static void main(String[] args) {
        List<List<Character>>res=calculate("112");
        for (List<Character> list:res) {
            System.out.println(list);
        }
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
            if (i != 0 && str.charAt(i)== str.charAt(i-1) && !visited[i - 1]) {
                continue;  // 防止重复
            }
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
}
