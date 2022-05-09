package nowcoder.链表;

public class 判断链表是否有环 {
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        for(int i=1;i<5;i++){
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        cur.next = head;
        System.out.println(hasCycle(head));
    }
}
