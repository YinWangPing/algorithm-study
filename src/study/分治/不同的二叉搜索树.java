package study.分治;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
public class 不同的二叉搜索树 {
    public static void main(String[] args) {

    }
    public List<TreeNode> generateTrees(int n) {
        if (n < 1) {
            return new LinkedList<TreeNode>();
        }
        return generateSubtrees(1, n);
    }
    public List<TreeNode> generateSubtrees(int start,int end){
        List<TreeNode> res=new ArrayList<>();
        if(start>end){
            res.add(null);
            return res;
        }
        for (int i = start; i <=end ; i++) {
            List<TreeNode> left=generateSubtrees(start,i);
            List<TreeNode> right=generateSubtrees(i+1,end);
            for (TreeNode l:left) {
                for (TreeNode r:right) {
                    TreeNode root=new TreeNode(i);
                    root.left=l;
                    root.right=r;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
