package study.剑指offer;

/**
 * @description:给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * @author: WangPingYin
 * @time: 2020/2/14 10:20
 */
class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
public class 二叉树的下一个节点 {
    public static void main(String[] args) {

    }
    public static TreeLinkNode getNext(TreeLinkNode node){
        if(node.right!=null){
            TreeLinkNode temp=node.right;
            while (temp.left!=null){
                temp=temp.left;
            }
            return temp;
        }else{
            while (node.next!=null){//向上遍历找出该节点的第一个左父节点
                TreeLinkNode parent=node.next;
                if(node==parent.left){
                    return parent;
                }
                node=node.next;
            }
        }
        return null;
    }
}
