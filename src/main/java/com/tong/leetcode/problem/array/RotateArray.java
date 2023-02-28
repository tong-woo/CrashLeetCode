package com.tong.leetcode.problem.array;

/**
 * LeetCode 189
 * Array Flip
 * 3 flips
 * @see <a href="https://leetcode.cn/problems/rotate-array/">RotateArray</a>
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        // total of k%length elements will be moved
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }
}
