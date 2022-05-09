package nowcoder.链表;

import java.util.Random;

//公共类
public class ListNode{
    int val;
    ListNode next = null;
    public ListNode(){}
    public ListNode(int i) {
        val = i;
    }

    public ListNode createList(int n) {
        ListNode head = new ListNode(0);
        ListNode cur = head;

        Random r = new Random();
        for(int i=1;i<=n;i++) {
            cur.next = new ListNode(r.nextInt(10000));
            cur = cur.next;
        }
        return head.next;
    }
}
