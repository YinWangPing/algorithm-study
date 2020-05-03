package study.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/4/29 21:09
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class 二叉树根节点到叶子节点的路径 {
    public static void main(String[] args) {

    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String>res=new ArrayList<>();
        if(root==null){
            return res;
        }
        List<Integer>path=new ArrayList<>();
        dfs(root,res,path);
        return res;
    }
    public void dfs(TreeNode root,List<String>res,List<Integer>path){
        if(root==null){
            return;
        }
        path.add(root.val);
        if(root.left==null&&root.right==null){
            res.add(buildPath(path));
        }else {
            dfs(root.left,res,path);
            dfs(root.right,res,path);
        }
        path.remove(path.size()-1);
    }
    public String buildPath(List<Integer>path){
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i <path.size() ; i++) {
            sb.append(path.get(i));
            if(i!=path.size()-1){
                sb.append("->");
            }
        }
        return sb.toString();
    }
}
