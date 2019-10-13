package leetcode.medium;

import leetcode.common.TreeNode;
import leetcode.common.Utils;

import java.util.Stack;

public class Q98_ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        TreeNode curr = root;
        Stack<TreeNode> stack = new Stack<>();
        int lastV = 0;
        boolean init = false;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode node = stack.pop();
                if (!init) {
                    lastV = node.val;
                    init = true;
                } else {
                    if (lastV >= node.val) return false;
                    lastV = node.val;
                }
                curr = node.right;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Q98_ValidateBinarySearchTree q = new Q98_ValidateBinarySearchTree();
        TreeNode node = Utils.buildTree(2, 1, 3);
        System.out.println(q.isValidBST(node));
    }
}
