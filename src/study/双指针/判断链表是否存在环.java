package study.双指针;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}


public class 判断链表是否存在环 {
    public boolean hasCycle(ListNode head) {
        if(head==null){
            return false;
        }
        ListNode fast=head.next,slow=head;
        while (fast!=null&&slow!=null&&fast.next!=null){
            if(fast==slow){
                return true;
            }
            fast=fast.next.next;
            slow=slow.next;
        }
        return false;
    }
}
