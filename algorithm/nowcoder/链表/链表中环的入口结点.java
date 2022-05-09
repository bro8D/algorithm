package nowcoder.链表;

public class 链表中环的入口结点 {
    public static ListNode EntryNodeOfLoop(ListNode head) {
        if(head == null) return null;
        ListNode slow=head,fast=head;
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) break;
        }
        if(fast==null || fast.next==null) return null;
        fast = head;
        while(fast!=slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        for(int i=1;i<5;i++){
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        cur.next = head.next.next;
        System.out.println(EntryNodeOfLoop(head).val);
    }
}
