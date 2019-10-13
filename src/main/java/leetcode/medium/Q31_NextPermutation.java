package leetcode.medium;

import java.util.Arrays;

public class Q31_NextPermutation {

    public void nextPermutation(int[] nums) {
        if (nums == null) return;
        if (nums.length == 0 || nums.length == 1) return;

        for (int i = nums.length - 1; i >= 0; i --) {
            if (nums[i] >= nums[nums.length - 1]) {
                sort(nums, i);
            } else {
                for (int j = i; j < nums.length; j ++) {
                    if (nums[i] < nums[j]) {
                        swap(nums, i, j);
                        return;
                    }
                }
            }
        }
    }

    private void sort(int[] nums, int begin) {
        for (; begin < nums.length - 1; begin ++) {
            if (nums[begin] > nums[begin + 1]) {
                swap(nums, begin, begin + 1);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

    public static void main(String[] args) {
        Q31_NextPermutation q = new Q31_NextPermutation();
        int[] nums = new int[]{1, 2, 3};
        q.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
