package nowcoder.链表;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class 单链表的排序 {
    //辅助数组，取巧了，不合适
    public static ListNode sortInList(ListNode head) {
        ListNode p = head;
        ArrayList<Integer> linkedlist = new ArrayList<>();
        while(p != null) {
            linkedlist.add(p.val);
            p = p.next;
        }
        Collections.sort(linkedlist);
        p = head;
        for(int i=0;i<linkedlist.size();i++) {
            p.val = linkedlist.get(i);
            p = p.next;
        }
        return head;
    }

    //归并排序还是不熟，这道题的归并很好理解，就是觉得很繁琐，真的有必要这样吗
    public static ListNode merge_divid(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode left = head;
        ListNode mid = head.next;
        ListNode right = head.next.next;
        while(right != null && right.next != null) {
            left = left.next;
            mid = mid.next;
            right = right.next.next;
        }
        left.next = null;
        return merge(merge_divid(head),merge_divid(mid));
    }
    public static ListNode merge(ListNode head1,ListNode head2) {
        if(head1==null) return head2;
        if(head2==null) return head1;
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while(head1 !=null && head2 !=null) {
            if(head1.val < head2.val) {
                cur.next = head1;
                head1 = head1.next;
            } else {
                cur.next = head2;
                head2 = head2.next;
            }
            cur = cur.next;
        }
        cur.next = (head1==null ? head2:head1);
        return head.next;
     }


    public static void main(String[] args) {
        ListNode listnode = new ListNode(0);
        ListNode head = listnode.createList(10);
//        head = sortInList(head);
        head = merge_divid(head);
        while(head!=null){
            System.out.print(head.val+" ");
            head = head.next;
        }
    }
}
