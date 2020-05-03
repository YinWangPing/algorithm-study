package study.二叉树;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/3/16 11:39
 */

public class 二叉树展开 {
    public static void main(String[] args) {
        TreeNode root = TreeUtil.generateTreeWithThreeLevel(1,
                2, 5,
                3, 4, null, 6);
        TreeUtil.visitByLevel(root);

        new 二叉树展开().flatten1(root);

        TreeUtil.visitByLevel(root);
        TreeNode curr = root;
        while (curr != null) {
            System.out.print(curr.val + "\t");
            curr = curr.right;
        }

    }
    /**
     *二叉树展开
     */
    public void flatten(TreeNode root) {
        if(root==null){
            return;
        }
        TreeNode curr=root;
        while (curr!=null){
            if(curr.left!=null){
                TreeNode rightMost=curr.left;
                while (rightMost.right!=null){
                    rightMost=rightMost.right;
                }
                rightMost.right=curr.right;
                curr.right=curr.left;
                curr.left=null;
            }
            curr=curr.right;
        }
    }
    private TreeNode pre = null;
    public void flatten1(TreeNode root) {
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }
}
