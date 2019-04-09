package leetcode.medium;

import leetcode.common.ListNode;
import leetcode.common.Utils;

/**
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 *
 * 示例 1:
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2:
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode i = head, j = head;
        while (j.next != null && j.next.next != null) {
            i = i.next;
            j = j.next.next;
        }
        j = i.next;
        i.next = null;
        i = head;

        if (i.next != null) i = sortList(i);
        if (j.next != null) j = sortList(j);
        return merge(i, j);
    }

    /**
     * 合并2个排序列表
     */
    private ListNode merge(ListNode i, ListNode j) {
        if (i == null && j == null) return null;
        if (i == null) return j;
        if (j == null) return i;
        ListNode re = new ListNode(0), curr = re;
        while (i != null && j != null) {
            if (i.val <= j.val) {
                curr.next = i;
                i = i.next;
            } else {
                curr.next = j;
                j = j.next;
            }
            curr = curr.next;
        }
        curr.next = i != null ? i : j;
        return re.next;
    }

    public static void main(String[] args) {
        SortList sortList = new SortList();
        ListNode head = Utils.buildList(4, 2, 1, 3);
        ListNode re = sortList.sortList(head);
        Utils.printList(re);

        head = Utils.buildList(-1, 5, 3, 4, 0);
        re = sortList.sortList(head);
        Utils.printList(re);
    }
}
