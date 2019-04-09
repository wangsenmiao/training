package leetcode.common;

public class Utils {
    public static ListNode buildList(int... values) {
        if (values == null) return null;
        ListNode head = new ListNode(values[0]);
        ListNode curr = head;
        for (int i = 1; i < values.length; i ++) {
            curr.next = new ListNode(values[i]);
            curr = curr.next;
        }
        return head;
    }

    public static void printList(ListNode head) {
        if (head == null) return;
        StringBuilder sb = new StringBuilder(head.val + ", ");
        while (head.next != null) {
            sb.append(head.next.val).append(", ");
            head = head.next;
        }
        System.out.println("[" + sb.substring(0, sb.length() - 2) + "]");
    }
}
