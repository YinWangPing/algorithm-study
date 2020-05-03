package study.二叉树;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/3/16 17:33
 */

public class 二叉树最大路径和 {
    public static void main(String[] args) {

    }
    int maxValue = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPathSumOfTree(root);
        return maxValue;
    }

    private int maxPathSumOfTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 当前结点左分支的最大和
        int leftSum = Math.max(maxPathSumOfTree(root.left), 0);

        // 当前结点右分支的最大和
        int rightSum = Math.max(maxPathSumOfTree(root.right), 0);

        maxValue = Math.max(maxValue, root.val+leftSum+rightSum);

        return Math.max(leftSum, rightSum) + root.val;
    }
    public int maxPathSum1(TreeNode root) {
        int[] res = {Integer.MIN_VALUE};
        int r = findMaxPathSumHelper(root, res);
        return res[0];
    }

    public int findMaxPathSumHelper(TreeNode root, int[] res) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, findMaxPathSumHelper(root.left, res));
        int right = Math.max(0, findMaxPathSumHelper(root.right, res));
        res[0] = Math.max(res[0], left+right+root.val);
        return Math.max(left, right) + root.val;
    }
}
