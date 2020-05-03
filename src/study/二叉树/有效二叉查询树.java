package study.二叉树;

import java.util.Stack;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/3/15 11:38
 */

public class 有效二叉查询树 {
    static long  preVal = Long.MIN_VALUE;
    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE-1);
    }
    public static boolean isValidBST(TreeNode root) {
        if(root==null)return true;
        if(!isValidBST(root.left)){
            return false;
        }
        if(root.val<=preVal){
            return false;
        }
        preVal=root.val;
        if(!isValidBST(root.right)){
            return false;
        }
        return true;
    }
    public static boolean isValidBST1(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        long pre = Long.MIN_VALUE;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (curr.val <= pre) {
                return false;
            }
            pre = curr.val;
            curr = curr.right;
        }
        return true;
    }
    public static boolean isValidBST2(TreeNode root){
        if(root==null){
            return true;
        }
        Stack<TreeNode>stack=new Stack<TreeNode>();
        TreeNode node=root;
        while (node!=null||!stack.isEmpty()){
            while (node!=null){
                stack.push(node);
                node=node.right;
            }
            node=stack.pop();
            if(node.val<=preVal){
                return false;
            }
            preVal=node.val;
            node=node.right;
        }
        return true;
    }
}
