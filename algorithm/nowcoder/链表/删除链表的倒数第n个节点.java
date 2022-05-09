package nowcoder.链表;

public class 删除链表的倒数第n个节点 {
    public static ListNode removeNthFromEnd(ListNode head,int n) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode fast = newHead,slow=newHead,pre=null;
        while(n-- >0) {
            fast = fast.next;
        }
        System.out.println();
        while(fast != null) {
            fast = fast.next;
            pre = slow;
            slow = slow.next;
        }
        pre.next = pre.next.next;
        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode();
        ListNode head = list.createList(10);
        head = removeNthFromEnd(head,10);
        for(ListNode node=head;node != null ;node = node.next) {
            System.out.print(node.val+" ");
        }
    }
}
