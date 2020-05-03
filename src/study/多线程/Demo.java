///**
// * @description:
// * @author: WangPingYin
// * @time: 2020/2/21 17:13
// */
//class ListNode1 {
//    int val;
//    ListNode next;
//
//    ListNode1(int x) {
//        val = x;
//    }
//}
//
//public class Demo {
//    public static void main(String[] args) {
//        Integer.
//    }
//
//    public ListNode mergeKLists(ListNode[] lists) {
//        int[] arr = new int[lists.size()];
//        for (int i = 0; i < lists.size(); i++) {
//            arr[i] = lists[i].val;
//        }
//        ListNode res = new ListNode(0);
//
//
//    }
//
//    public static ListNode mergeTwoList(ListNode node1, ListNode node2) {
//        if (node1 == null && node2 == null) {
//            return null;
//        }
//        if (node1 == null) {
//            return node2;
//        }
//        if (node2 == null) {
//            return node1;
//
//        }
//        ListNode head = null;
//        if (node1.val > node2.val) {
//            head = node2;
//            head.next = mergeTwoList(node1, node2.next);
//        } else {
//            head = node1;
//            head.next = mergeTwoList(node1.next, node2);
//        }
//        return head;
//    }
//    public ListNode Merge(ListNode list1, ListNode list2) {
//        ListNode head = new ListNode(-1);
//        ListNode cur = head;
//        while (list1 != null && list2 != null) {
//            if (list1.val <= list2.val) {
//                cur.next = list1;
//                list1 = list1.next;
//            } else {
//                cur.next = list2;
//                list2 = list2.next;
//            }
//            cur = cur.next;
//        }
//        if (list1 != null)
//            cur.next = list1;
//        if (list2 != null)
//            cur.next = list2;
//        return head.next;
//    }
//}
