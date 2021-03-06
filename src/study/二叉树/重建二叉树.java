package study.二叉树;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/3/15 21:34
 */

public class 重建二叉树 {
    public static void main(String[] args) {

    }

    /**
     * 递归构建使用map保存中序索引
     */
    private static Map<Integer, Integer> map = new HashMap<>();

    public static TreeNode constructBinTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);//保存中序索引
        }
        return reConstructTree(preorder, 0, preorder.length - 1, 0);
    }

    public static TreeNode reConstructTree(int[] preorder, int preL, int preR, int inL) {
        if (preL > preR) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preL]);//根节点为前序遍历的第一个节点
        int index = map.get(root.val);
        int leftTreeSize = index - inL;//左子树长度
        root.left = reConstructTree(preorder, preL + 1, preL + leftTreeSize, inL);//重构左子树
        root.right = reConstructTree(preorder, preL + leftTreeSize + 1, preR, inL + leftTreeSize + 1);//重构右子树
        return root;
    }

    //    private static HashMap<Integer,Integer>map=new HashMap<>();
//    public static TreeNode constructBinTree(int[] preorder, int[] inorder){
//        for (int i = 0; i <inorder.length ; i++) {
//            map.put(inorder[i],i);
//        }
//        return reConstructTree(preorder,0,preorder.length-1,0);
//    }
//    public static TreeNode reConstructTree(int []preorder,int preL,int preR,int inL){
//        if(preL>preR){
//            return null;
//        }
//        TreeNode root=new TreeNode(preorder[preL]);
//        int leftTreeSize=map.get(preorder[preL])-inL;
//        root.left=reConstructTree(preorder,preL+1,preL+leftTreeSize,inL);
//        root.right=reConstructTree(preorder,preL+leftTreeSize+1,preR,inL+leftTreeSize+1);
//        return root;
//    }
    private static Map<Integer, Integer> imap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i <inorder.length ; i++) {
            imap.put(inorder[i],i);
        }
        return reConstructTree1(preorder,0,inorder.length-1,0);
    }
    public TreeNode reConstructTree1(int []preorder,int preL,int preR,int inL){
        if(preL>preR){
            return null;
        }
        TreeNode root=new TreeNode(preorder[preL]);
        int index=imap.get(preorder[preL]);
        int leftSize=index-inL;
        root.left=reConstructTree1(preorder,preL+1,preL+leftSize,inL);
        root.right=reConstructTree1(preorder,preL+leftSize+1,preR,inL+leftSize+1);
        return root;
    }

    private static Map<Integer, Integer> inmap = new HashMap<>();
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        for (int i = 0; i <inorder.length ; i++) {
            inmap.put(inorder[i],i);
        }
        return reBuildTree(preorder,0,preorder.length-1,0);
    }
    public TreeNode reBuildTree(int []preorder,int preL,int preR,int inL){
        if(preorder==null||preorder.length==0){
            return null;
        }
        TreeNode root=new TreeNode(preorder[preL]);
        int index=inmap.get(preorder[preL]);
        int leftTreeSize=index-inL;
        root.left=reBuildTree(preorder,preL+1,preL+leftTreeSize,inL);
        root.right=reBuildTree(preorder,preL+leftTreeSize+1,preR,inL+leftTreeSize+1);
        return root;
    }
}
