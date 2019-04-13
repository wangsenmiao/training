package leetcode.medium;

import leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class Q102_BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        traverse(queue, result, queue.size());
        return result;
    }

    private void traverse(Queue<TreeNode> queue, List<List<Integer>> result, int count) {
        List<Integer> list = new LinkedList<>();
        int newCount = 0;
        while (count -- != 0) {
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null)  {
                queue.offer(node.left);
                newCount ++;
            }
            if (node.right != null) {
                queue.offer(node.right);
                newCount ++;
            }
        }
        result.add(list);
        if (newCount > 0) {
            traverse(queue, result, newCount);
        }
    }


    public static void main(String[] args) {
        Q102_BinaryTreeLevelOrderTraversal q = new Q102_BinaryTreeLevelOrderTraversal();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);

        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(q.levelOrder(root));
    }
}
