package study.二叉树;

import java.util.Stack;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/4/20 12:10
 */
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
//class Node {
//    int val = 0;
//    Node left = null;
//    Node right = null;
//
//    public Node(int val) {
//        this.val = val;
//    }
//
//}
public class 二叉搜索树与双向链表 {
    public static void main(String[] args) {
        Node t1=new Node(4);
        t1.left=new Node(2);
        t1.right=new Node(5);
        t1.left.left=new Node(1);
        t1.left.right=new Node(3);
        Node res=Convert(t1);
    }
    public TreeNode Convert(TreeNode root) {
        if(root == null){
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        TreeNode pre = null, head = null, tail = null;
        while(!stack.isEmpty() || current != null) {
            while(current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            tail = current;
            if(pre == null) {//处理头结点
                head = current;
            }else {
                pre.right = current;
                current.left = pre;
            }
            pre = current;
            current = current.right;
        }
        tail.right = head;
        head.left = tail;
        return head;
    }
    static Node pre, head;
    public static Node treeToDoublyList(Node root) {
        if(root == null) return null;
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }
    public static void  dfs(Node cur) {
        if(cur == null) return;
        dfs(cur.left);
        if(pre != null) pre.right = cur;
        else head = cur;
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }
//    Node pre = null;
//    Node head = null;


    public static Node Convert(Node root) {
        ConvertSub(root);
        return head;
    }
    private static void ConvertSub(Node cur) {
        if(cur==null) return;
        ConvertSub(cur.left);
        if (pre == null) {
            pre = cur;
            head = cur;
        } else {
            pre.right = cur;
            cur.left = pre;
            pre = cur;
        }
        ConvertSub(cur.right);
    }
}
