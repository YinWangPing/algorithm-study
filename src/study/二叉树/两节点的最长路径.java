package study.二叉树;

public class 两节点的最长路径 {
    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;
    }

    private int depth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        max = Math.max(max, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth) + 1;
    }

}
