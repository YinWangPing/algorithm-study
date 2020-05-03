package study.剑指offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/2/13 14:32
 */
class ListNode{
    public Integer val;
    public ListNode next=null;
    public ListNode(Integer val){
        this.val=val;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
public class 从头到尾打印链表 {
    public static void main(String[] args) {
        ListNode listNode=new ListNode(1);
        listNode.setNext(new ListNode(3));
        listNode.next.setNext(new ListNode(5));
        listNode.next.next.setNext(new ListNode(7));
        ArrayList<Integer> list=printListFromTailToHead1(listNode);
        for (Integer i:list) {
            System.out.println(i);
        }
    }
    /**
     *通过头插法实现
     */
    public static ArrayList<Integer> printListFromTailToHead0(ListNode listNode) {
        ArrayList<Integer> list=new ArrayList<>();
        ListNode temp=new ListNode(0);
        ListNode res=temp;
        while (listNode!=null){
            ListNode lnext=listNode.next;//保存下一个
            listNode.next=res.next;//将当前要插入节点指向头节点的next
            res.next=listNode;
            listNode=lnext;
        }
        while (res.next!=null){
            list.add(res.next.val);
            res=res.next;
        }
        return list;
    }
    /**
     *通过递归实现
     */
    public static ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (listNode != null) {
            ret.addAll(printListFromTailToHead1(listNode.next));
            ret.add(listNode.val);
        }
        return ret;
    }
    /**
     *通过栈实现
     */
    public static ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> list=new ArrayList<>();
        Stack<Integer> stack=new Stack<>();
        while (listNode!=null){
            stack.push(listNode.val);
            listNode=listNode.next;
        }
        while (!stack.empty()){
            list.add(stack.pop());
        }
        return list;
    }
}
