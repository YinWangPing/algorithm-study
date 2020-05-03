package study.二叉树;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/3/16 17:18
 */

public class 二叉树反转 {
    public static void main(String[] args) {

    }
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return root;
        }
        TreeNode node=root.left;
        root.left=invertTree(root.right);
        root.right=invertTree(node);
        return root;
    }
    public TreeNode invertTree1(TreeNode root) {
        if (root != null) {
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            invertTree1(root.left);
            invertTree1(root.right);
        }
        return root;
    }
}
