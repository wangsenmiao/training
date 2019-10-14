package leetcode.medium;

import leetcode.common.TreeNode;

import java.util.Stack;

/**
 * 给定一个二叉树，原地将它展开为链表。
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 *
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *
 * 输入：[1,2,5,3,4,null,6]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6]
 */
public class Q114_FlattenBinaryTreeToLinkedList {

    public void flatten(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return;
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;
        TreeNode prev = root;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                if (curr.left == null) prev = curr;
                curr = curr.left;
            } else {
                curr = stack.pop();
                if (curr.right != null) {
                    prev.left = curr.right;
                    curr.right = null;
                    curr = prev.left;
                } else {
                    curr = curr.right;
                }
            }
        }

        curr = root;
        while (curr.left != null) {
            curr.right = curr.left;
            curr.left = null;
            curr = curr.right;
        }
    }

    public static void main(String[] args) {

    }
}
