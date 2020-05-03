package study.二叉树;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/3/15 21:28
 */

public class 二叉树最小深度 {
    public static void main(String[] args) {

    }
    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left != null && root.right != null) {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }else {
            return minDepth(root.left) + minDepth(root.right) + 1;
        }
    }
}
