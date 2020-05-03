package study.剑指offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:输入某二叉树的前序遍历和中序遍历的结果，
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
 * 则重建二叉树并返回。
 * @author: WangPingYin
 * @time: 2020/2/13 15:34
 */
class TreeNode{
    int val;
    TreeNode left=null;
    TreeNode right=null;
    public TreeNode(int val){
        this.val=val;
    }
}
public class 重建二叉树 {
    public static void main(String[] args) {
        int []preOrder=new int[]{1,2,4,7,3,5,6,8};
        int []inOrder=new int[]{4,7,2,1,5,3,8,6};
        TreeNode root = constructBinTree1(preOrder, inOrder);
        visit(root);
    }
    /**
     *序遍历的第一个值为根节点的值，使用这个值将中序遍历结果分成两部分，
     * 左部分为树的左子树中序遍历结果，右部分为树的右子树中序遍历的结果。
     * 然后分别对左右子树递归地求解。
     */
    public static TreeNode constructBinTree0(int[] preorder, int[] inorder){
        // 递归终止条件
        if(preorder == null || preorder.length == 0) return null;

        //从先序遍历结果中取出根结点
        int rootId = preorder[0];
        TreeNode rootNode = new TreeNode(rootId);

        // 查找该根结点在中序遍历结果中的位置（索引）
        int idxOfRoot = 0;
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == rootId){
                idxOfRoot = i;
                break;
            }
        }

        int leftChildNum = idxOfRoot;
        int rightChildNum = inorder.length - idxOfRoot - 1;

        // 左孩子构成的子树
        if (leftChildNum > 0) {
            int[] leftPreorder = new int[leftChildNum];
            int[] leftInorder = new int[leftChildNum];
            for (int i = 0; i < leftChildNum; i++){
                leftPreorder[i] = preorder[1+i];  // 取出先序遍历结果中根结点的左孩子结点
                leftInorder[i] = inorder[i];  // 取出中序遍历结果中根结点的左孩子结点
            }
            TreeNode leftChildNode = constructBinTree0(leftPreorder, leftInorder);
            rootNode.left=leftChildNode;
        }

        // 右孩子构成的子树
        if (rightChildNum > 0){
            int[] rightPreorder = new int[rightChildNum];
            int[] rightInorder = new int[rightChildNum];
            for(int k = 0; k < rightChildNum; k++){
                rightPreorder[k] = preorder[1+leftChildNum+k];  // 取出先序遍历结果中根结点的右孩子结点
                rightInorder[k] = inorder[1+leftChildNum+k];  // 取出中序遍历结果中根结点的右孩子结点
            }
            TreeNode rightChildNode = constructBinTree0(rightPreorder, rightInorder);
            rootNode.right=rightChildNode;
        }

        return rootNode;
    }
    /**
     *递归构建使用map保存中序索引
     */
    private static Map<Integer, Integer> map = new HashMap<>();
    public static TreeNode constructBinTree1(int[] preorder, int[] inorder){
        for (int i = 0; i <inorder.length ; i++) {
            map.put(inorder[i],i);//保存中序索引
        }
        return reConstructTree(preorder,0,preorder.length-1,0);
    }
    public static TreeNode reConstructTree(int[] preorder, int preL,int preR,int inL) {
        if(preL>preR){
            return null;
        }
        TreeNode root=new TreeNode(preorder[preL]);//根节点为前序遍历的第一个节点
        int index=map.get(root.val);
        int leftTreeSize=index-inL;//左子树长度
        root.left=reConstructTree(preorder,preL+1,preL+leftTreeSize,inL);//重构左子树
        root.right=reConstructTree(preorder,preL+leftTreeSize+1,preR,inL+leftTreeSize+1);//重构右子树
        return root;
    }
    public static void previsit(TreeNode root){
        if (root == null) return;
        System.out.print(String.format("%s \t", root.val));
        previsit(root.left);
        previsit(root.right);
    }

    public static void invisit(TreeNode root){
        if (root == null) return;
        invisit(root.left);
        System.out.print(String.format("%s \t", root.val));
        invisit(root.right);
    }

    public static void postvisit(TreeNode root){
        if (root == null) return;
        postvisit(root.left);
        postvisit(root.right);
        System.out.print(String.format("%s \t", root.val));
    }

    public static void visit(TreeNode root){
        System.out.print("先序遍历结果：");
        previsit(root);
        System.out.println();
        System.out.print("中序遍历结果：");
        invisit(root);
        System.out.println();
        System.out.print("后序遍历结果：");
        postvisit(root);
        System.out.println("\n---------------------");
    }
}
