package study.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/4/29 22:25
 */

public class 组合 {
    public static void main(String[] args) {
        组合 ad=new 组合();
        List<List<Integer>> res=ad.combine(4,2);
        for (List<Integer> list:res) {
            System.out.println(list);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>>res=new ArrayList<>();
        List<Integer>path=new ArrayList<>();
        backingTracking(res,path,n,k,1);
        return res;
    }
    public void backingTracking(List<List<Integer>>res,List<Integer>path,int n, int k,int start){
        if(k==0){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i <=n-k+1 ; i++) {
            path.add(i);
            backingTracking(res,path,n,k-1,i+1);
            path.remove(path.size()-1);
        }
    }
}
