package nowcoder.链表;

import java.util.ArrayList;

public class 合并K个已排序列表 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        return dividMerge(lists, 0, lists.size() - 1);
    }

    public ListNode dividMerge(ArrayList<ListNode> lists, int left, int right) {
        if (left > right) return null;
        else if (left == right) return lists.get(left);
        int mid = left + (right - left >> 1);
        return merge(dividMerge(lists, left, mid), dividMerge(lists, mid + 1, right));
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null) {
            cur.next = l1;
        } else {
            cur.next = l2;
        }
        return head.next;
    }

    public static void main(String[] args) {
//        System.out.println(1>>1); 测试一下 1/2=0
    }
}
