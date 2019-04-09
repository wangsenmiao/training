package leetcode.easy;

import java.util.Arrays;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class TowSum {
    public int[] twoSum(int[] nums, int target) {
        final int[] result = new int[2];
        final int length = nums.length;
        for (int i = 0; i < length; i ++) {
            int a = nums[i];
            int b = target - a;
            for (int inner = i + 1; inner < length; inner ++) {
                if (nums[inner] == b) {
                    result[0] = i;
                    result[1] = inner;
                    return result;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TowSum towSum = new TowSum();
        int[] re = towSum.twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(re));
    }
}
