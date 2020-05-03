import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/2/17 20:02
 */
class TreeNode1 {
    int data;
    TreeNode1 leftNode;
    TreeNode1 rightNode;
    public TreeNode1() {
    }
    public TreeNode1(int d) {
        data = d;
    }
    public TreeNode1(TreeNode1 left, TreeNode1 right, int d) {
        leftNode = left;
        rightNode = right;
        data = d;
    }
}

public class Sort {
    public static void main(String[] args) {
        TreeNode1 head = new TreeNode1(1);
        TreeNode1 second = new TreeNode1(2);
        TreeNode1 three = new TreeNode1(3);
        TreeNode1 four = new TreeNode1(4);
        TreeNode1 five = new TreeNode1(5);
        TreeNode1 six = new TreeNode1(6);
        TreeNode1 seven = new TreeNode1(7);
        head.rightNode = three;
        head.leftNode = second;
        second.rightNode = five;
        second.leftNode = four;
        three.rightNode = seven;
        three.leftNode = six;
        System.out.print("广度优先遍历结果：");
        new Sort().BroadFirstSearch(head);
        System.out.println();
        System.out.print("深度优先遍历结果：");
        new Sort().depthFirstSearch(head);
    }

    //广度优先遍历是使用队列实现的
    public static void BroadFirstSearch(TreeNode1 head){
        if(head==null){
            return;
        }
        Queue<TreeNode1>queue=new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()){
            TreeNode1 node=queue.poll();
            System.out.print(String.format("%s \t",node.data));
            if(node.leftNode!=null){
                queue.add(node.leftNode);
            }
            if(node.rightNode!=null){
                queue.add(node.rightNode);
            }
        }
    }

    //深度优先遍历
  public static void depthFirstSearch(TreeNode1 head){
        if(head==null){
            return;
        }
        Stack<TreeNode1>stack=new Stack<>();
        stack.add(head);
        while (!stack.isEmpty()){
            TreeNode1 node=stack.pop();
            System.out.print(String.format("%s \t",node.data));
            if(node.rightNode!=null){
                stack.add(node.rightNode);
            }
            if(node.leftNode!=null){
                stack.add(node.leftNode);
            }
        }
  }

}
