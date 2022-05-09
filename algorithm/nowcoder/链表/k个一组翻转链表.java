package nowcoder.链表;
public class k个一组翻转链表 {
    public static ListNode reverseKGroup(ListNode head, int k) {
        int listSize = 0;
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode pre = newHead, cur = head;
        while (cur != null) {
            listSize++;
            cur = cur.next;
        }
        cur = head;

        for (int i = k; i <= listSize; i += k) {
            ListNode flag = cur;
            for (int index = 0; index < k; index++) {
                ListNode next = cur.next;
                cur.next = pre.next;
                pre.next = cur;
                cur = next;
            }
            pre = flag;
            flag.next = cur;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for(int i=2;i<=5;i++){
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        ListNode list = reverseKGroup(head,3);
        while(list != null) {
            System.out.print(list.val+" ");
            list = list.next;
        }
    }
}
