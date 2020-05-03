package study.二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/3/17 16:03
 */

public class 先序遍历 {
    public static void main(String[] args) {

    }
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while ( !stack.isEmpty()) {
            TreeNode curr = stack.pop();
            res.add(curr.val);
            if(curr.right!=null){
                stack.push(curr.right);
            }
            if(curr.left!=null){
                stack.push(curr.left);
            }
        }

        return res;
    }
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traversa(root,res);
        return res;
    }
    public static void traversa(TreeNode root,List<Integer> list) {
        if(root!=null){
            list.add(root.val);
            if(root.left!=null){
                traversa(root.left,list);
            }
            if(root.right!=null){
                traversa(root.right,list);
            }
        }
    }
}
