package study.二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/3/14 21:16
 */

public class 二叉树中序遍历 {
    public static void main(String[] args) {
        TreeNode t1=new TreeNode(1);
        t1.left=new TreeNode(3);
        t1.right=new TreeNode(2);
        t1.left.left=new TreeNode(5);
        TreeNode t2=new TreeNode(2);
        t2.left=new TreeNode(1);
        t2.right=new TreeNode(3);
        t2.left.right=new TreeNode(4);
        t2.right.right=new TreeNode(7);
        TreeUtil.inVisit(t1);
        System.out.println("----------------");
        List<Integer> list=inorderTraversal(t1);
        for (int i:list) {
            System.out.println(i);
        }

    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
       if(root==null){
           return inorder;
       }
       Stack<TreeNode> stack=new Stack<TreeNode>();
       TreeNode node=root;
       while(node!=null||!stack.isEmpty()){
           while(node!=null){
               stack.push(node);
               node=node.left;
           }
           node=stack.pop();
           inorder.add(node.val);
           node=node.right;
       }
       return inorder;
    }

    public static List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        if (root == null) {
            return inorder;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {//存在左节点则入栈
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            inorder.add(curr.val);
            curr = curr.right;
        }

        return inorder;
    }
    public static List<Integer> inorderTraversa2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traversa(root,res);
        return res;
    }
    public static void traversa(TreeNode root,List<Integer> list) {
        if(root!=null){
            if(root.left!=null){
                traversa(root.left,list);
            }
            list.add(root.val);
            if(root.right!=null){
                traversa(root.right,list);
            }
        }
    }
}
