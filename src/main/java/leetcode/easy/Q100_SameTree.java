package leetcode.easy;

import leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * 示例 1:
 *
 * 输入:       1         1
 *           / \       / \
 *          2   3     2   3
 *
 *         [1,2,3],   [1,2,3]
 *
 * 输出: true
 * 示例 2:
 *
 * 输入:      1          1
 *           /           \
 *          2             2
 *
 *         [1,2],     [1,null,2]
 *
 * 输出: false
 * 示例 3:
 *
 * 输入:       1         1
 *           / \       / \
 *          2   1     1   2
 *
 *         [1,2,1],   [1,1,2]
 *
 * 输出: false
 */
public class Q100_SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null && q != null) return false;
        if (p != null && q == null) return false;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);queue.offer(q);
        while (!queue.isEmpty()) {
            TreeNode i = queue.poll();
            TreeNode j = queue.poll();
            if ((i == null && j != null) || (i != null && j == null) || i.val != j.val) {
                return false;
            }
            if (i.left != null && j.left != null) {
                queue.offer(i.left);
                queue.offer(j.left);
            } else if (i.left == null && j.left == null) {

            } else {
                return false;
            }
            if (i.right != null && j.right != null) {
                queue.offer(i.right);
                queue.offer(j.right);
            } else if (i.right == null && j.right == null) {

            } else {
                return false;
            }
        }
        return true;
    }


    /**
     * todo leetcode返回true？
     */
    public static void main(String[] args) {
        Q100_SameTree q = new Q100_SameTree();
        TreeNode root = new TreeNode(12);
        root.right = new TreeNode(-60);

        TreeNode root1 = new TreeNode(12);
        root1.right = new TreeNode(72);

        System.out.println(q.isSameTree(root, root1));
    }
}
