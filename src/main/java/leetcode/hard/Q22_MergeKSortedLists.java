package leetcode.hard;

import leetcode.common.ListNode;
import leetcode.common.Utils;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */
public class Q22_MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        if (lists.length == 1) return lists[0];

        int len = lists.length;
        while ((len - 1) / 2 >= 0) {
            int mid = (len - 1) / 2;
            int i = 0;
            while (i <= mid && i != len - i - 1) {
                lists[i] = mergeList(lists[i], lists[len - i - 1]);
                lists[len - i - 1] = null;
                i ++;
            }
            if (mid == 0) break;
            len = mid + 1;
        }
        return lists[0];
    }

    private ListNode mergeList(ListNode p, ListNode q) {
        if (p == null && q != null) return q;
        if (p != null && q == null) return p;
        if (p == null && q == null) return null;

        ListNode curr = new ListNode(-1);
        ListNode result = curr;
        while (true) {
            if (p == null) {
                curr.next = q;
                return result.next;
            }
            if (q == null) {
                curr.next = p;
                return result.next;
            }
            if (p.val < q.val) {
                curr.next = p;
                p = p.next;
            } else {
                curr.next = q;
                q = q.next;
            }
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        Q22_MergeKSortedLists q = new Q22_MergeKSortedLists();
        ListNode[] arr = new ListNode[]{Utils.buildList(1,4,5),
                Utils.buildList(1,3,4), Utils.buildList(2,6)};
        Utils.printList(q.mergeKLists(arr));
    }
}
