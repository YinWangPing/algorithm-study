package study.二叉树;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/3/15 21:06
 */

import java.util.ArrayList;
import java.util.List;

/**
 *public List<List<Integer>> levelOrder(TreeNode root) {
 *         List<List<Integer>> result = new ArrayList<>();
 *         if (root == null) {
 *             return result;
 *         }
 *         levelOrder(root, 0, result);
 *         return result;
 *     }
 *
 *     public void levelOrder(TreeNode root, int level, List<List<Integer>> list) {
 *         if (root != null) {
 *             if (list.size() == level) {
 *                 list.add(new ArrayList<>());
 *             }
 *
 *             list.get(level).add(root.val);
 *             levelOrder(root.left, level+1, list);
 *             levelOrder(root.right, level+1, list);
 *         }
 *     }
 */
public class 层次遍历 {
    public static void main(String[] args) {

    }
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>>res=new ArrayList<>();
        if(root==null){
            return res;
        }
        levelOrder(root,0,res);
        return res;
    }
    public static void levelOrder(TreeNode root,int level,List<List<Integer>> list) {
        if(root!=null){
            if(list.size()==level){
                list.add(new ArrayList<>());
            }
            list.get(level).add(root.val);
            levelOrder(root.left,level+1,list);
            levelOrder(root.right,level+1,list);
        }
    }
}
