package nowcoder.链表;

public class 两个链表的第一个公共结点 { //这个解法真的清晰 我写不出
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode l1 = pHead1, l2 = pHead2;
        while (l1 != l2) {
            l1 = (l1 == null ? pHead2 : l1.next);
            l2 = (l2 == null ? pHead1 : l2.next);
        }
        return l2;
    }
}
