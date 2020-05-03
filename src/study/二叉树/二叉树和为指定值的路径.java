package study.二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/3/31 11:52
 */

public class 二叉树和为指定值的路径 {
    public static void main(String[] args) {
        TreeNode node = TreeUtil.generateTreeWithThreeLevel(1,
                2, 5,
                3, 4, null, 6);
        List<List<Integer>>lists=findPath(node,7);
        for (int i = 0; i <lists.size() ; i++) {
            for (int j = 0; j <lists.get(i).size() ; j++) {
                System.out.println(lists.get(i).get(j));
            }
        }
//        System.out.println("----------------------------");
//        List<Integer>res=preOrder(node);
//        for (int i:res) {
//            System.out.print(i+"\t");
//        }
    }
    static List<List<Integer>> pathList = new ArrayList<List<Integer>>();
    static ArrayList<Integer> path = new ArrayList<Integer>();
    public static List<List<Integer>> findPath(TreeNode node, int target){
        if(node==null){
            return pathList;
        }
        path.add(node.val);
        if(node.left == null && node.right == null && target == node.val)
        {
            pathList.add(new ArrayList<Integer>(path));
        }
        if(node.left != null){
            findPath(node.left,target-node.val);
        }
        if(node.right != null)
        {
            findPath(node.right,target-node.val);
        }
        path.remove(path.size()-1);
        return pathList;
    }
    public static List<Integer> preOrder(TreeNode node){
        ArrayList<Integer> res=new ArrayList<>();
        Stack<TreeNode>stack=new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()){
            TreeNode curr=stack.pop();
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
}
