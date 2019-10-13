package leetcode.medium;

import leetcode.common.TreeNode;
import leetcode.common.Utils;

import java.util.*;

/**
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */
public class Q113_PathSumII {
    //todo ?
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        Stack<TreeNode> re = new Stack<>();
        int currSum = 0;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                re.push(curr);
                currSum += curr.val;

                if (curr.left == null && curr.right == null) {
                    if (currSum == sum) {
                        result.add(copy(re));
                    }
                }

                curr = curr.left;
            } else {
                curr = stack.pop();
                if (curr.right == null) {
                    currSum -= re.pop().val;
                }
                curr = curr.right;
            }
        }
        return result;
    }

    private List<Integer> copy(Stack<TreeNode> stack) {
        TreeNode[] arr = stack.toArray(new TreeNode[]{});
        List<Integer> list = new ArrayList<>();
        for (TreeNode node : arr) {
            list.add(node.val);
        }
        return list;
    }

    public static void main(String[] args) {
        Q113_PathSumII q = new Q113_PathSumII();
        Integer[] arr = new Integer[]{5,4,8,11,null,13,4,7,2,null,null,5,1};
        TreeNode node = Utils.buildTree(arr);
        System.out.println(q.pathSum(node, 22));
//        Utils.printTree(node);
    }
}
