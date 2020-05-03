package study.二叉树;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/3/15 21:15
 */

public class 二叉树最大深度 {
    public static void main(String[] args) {

    }
    public static int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left=maxDepth(root.left);
        int right=maxDepth(root.right);
        return Math.min(left,right)+1;
    }
}
