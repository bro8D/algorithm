package nowcoder.链表;

public class 链表相加 {
    //翻转再翻转
    public ListNode addInList (ListNode head1, ListNode head2) {
        if(head1==null) return head2;
        if(head2==null) return head1;
        int sum = 0;
        head1 = reverseList(head1);
        head2 = reverseList(head2);
        ListNode head = new ListNode(-1);
        head.next = null;
        while (head1 != null || head2 != null) {
            if(head1 != null) {
                sum+=head1.val;
                head1 = head1.next;
            }
            if(head2 != null) {
                sum+=head2.val;
                head2 = head2.next;
            }
            ListNode node = new ListNode(sum % 10);
            node.next = head.next;
            head.next = node;
            sum /= 10;
        }
        if (sum != 0) {
            ListNode node = new ListNode(sum);
            node.next = head.next;
            head.next = node;
        }
        return head.next;
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
