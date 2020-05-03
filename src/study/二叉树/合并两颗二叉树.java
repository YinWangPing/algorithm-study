package study.二叉树;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/3/14 20:38
 */
/**
 *  * Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.
 *  *
 *  * You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.
 *  *
 *  * Example 1:
 *  *
 *  * Input:
 *  * 	Tree 1                     Tree 2
 *  *           1                         2
 *  *          / \                       / \
 *  *         3   2                     1   3
 *  *        /                           \   \
 *  *       5                             4   7
 *  * Output:
 *  * Merged tree:
 *  * 	     3
 *  * 	    / \
 *  * 	   4   5
 *  * 	  / \   \
 *  * 	 5   4   7
 *  *
 *  *
 *  * Note: The merging process must start from the root nodes of both trees.
 *  *
 */
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val){
        this.val=val;
    }
}
public class 合并两颗二叉树 {
    public static int [] test=new int[9];
    public static int count=0;
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
        TreeNode res=mergeTrees(t1,t2);
        preVisit(res);
    }
    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
       if(t1==null){
           return t2;
       }
       if(t2==null){
           return t1;
       }
       //处理根节点
        TreeNode root=new TreeNode(t1.val+t2.val);
       //递归处理左右子树
        root.left=mergeTrees(t1.left,t2.left);
        root.right=mergeTrees(t1.right,t2.right);
       return root;
    }
    public static void preVisit(TreeNode node){
        if(node==null)return;
        System.out.println(node.val);
//        test[count++]=node.val;
        preVisit(node.left);
        preVisit(node.right);
    }
    public static void inVisit(TreeNode node){
        if(node==null)return;
        inVisit(node.left);
        System.out.println(node.val);
        inVisit(node.right);
    }
    public static void posVisit(TreeNode node){
        if(node==null)return;
        posVisit(node.left);
        posVisit(node.right);
        System.out.println(node.val);
    }
}
