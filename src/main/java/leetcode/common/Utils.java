package leetcode.common;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

    public static TreeNode buildTree(Integer... values) {
        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int len = values.length, i = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            assert node != null;
            if (++ i < len && values[i] != null) {
                node.left = new TreeNode(values[i]);
                queue.offer(node.left);
            }
            if (++ i < len && values[i] != null) {
                node.right = new TreeNode(values[i]);
                queue.offer(node.right);
            }
        }
        return root;
    }

    public static void printTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> result = new LinkedList<>();
        queue.offer(root);
        TreeNode curr;
        while (!queue.isEmpty()) {
            curr = queue.poll();
            if (curr == null) {
                result.add(null);
            } else {
                result.add(curr.val);
                queue.offer(curr.left);
                queue.offer(curr.right);
            }
        }
        int idx = result.size() - 1;
        while (result.get(idx) == null) {
            result.remove(idx --);
        }
        System.out.println(result);
    }
}
