package nowcoder.链表;

public class 判断链表是否为回文链表 {
    public boolean isPail(ListNode head) {
        ListNode fast = head,slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //fast != null 说明是奇数长度
        if(fast != null) {
            //奇数时中点不用判断。直接跳过
            slow = slow.next;
        }
        slow = reverse(slow);
        fast = head;
        while (slow != null) {
            if(fast.val != slow.val) return false;
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }
    public ListNode reverse(ListNode head) {//翻转链表还是不够熟练
        ListNode prev = null;
        while(head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
