package nowcoder.链表;

import java.util.List;

public class 合并2个排序链表 {
    public static ListNode Merge(ListNode list1,ListNode list2) {
        ListNode newHead = new ListNode(-1);
        ListNode cur = newHead;
        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if(list1!=null){
            cur.next = list1;
        } else cur.next = list2;

        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode head_1 = new ListNode(1);
        ListNode cur = head_1;
        for(int i=2;i<=5;i++){
            cur.next = new ListNode(i);
            cur = cur.next;
        }

        ListNode head_2 = new ListNode(1);
        cur = head_2;
        for(int i=2;i<=5;i++){
            cur.next = new ListNode(i);
            cur = cur.next;
        }

        ListNode list = Merge(head_1,head_2);
        for(ListNode node = list;node != null;node = node.next){
            System.out.print(node.val+" ");
        }
    }
}
