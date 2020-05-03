package study.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/4/29 22:51
 */

public class 组合求和 {
    public static void main(String[] args) {
        组合求和 ad = new 组合求和();
        int[] nums = new int[]{2, 3, 4, 7};
        List<List<Integer>> res = ad.combinationSum(nums, 7);
        for (List<Integer> list : res) {
            System.out.println(list);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtracking(res, path, target, candidates, 0);
        return res;
    }

    public void backtracking(List<List<Integer>> res, List<Integer> path, int target, int[] candidates, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            path.add(candidates[i]);
            backtracking(res, path, target - candidates[i], candidates, i);
            path.remove(path.size() - 1);

        }
    }
}
