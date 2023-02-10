package com.tong.leetcode.problem.slidingwindow;

/**
 * Given an array of integers nums and an integer k.
 * A continuous subarray is called nice if there are k odd numbers on it.
 * Return the number of nice sub-arrays.
 *
 * LeetCode 1248
 *
 * @link https://leetcode.cn/problems/count-number-of-nice-subarrays/
 */
public class CountNumberOfNiceSubArrays {
    public static int numberOfSubArrays(int[] nums, int k) {
        int leftPointer = 0, rightPointer = 0, oddCount = 0, res = 0;
        while (rightPointer < nums.length) {
            // right pointer move first, collect the count of add number
            if ((nums[rightPointer++] & 1) == 1) oddCount++;

            // If now the current window (leftPointer, rightPointer) contains k odd numbers
            if (oddCount == k) {
                // first expand the window to right until the next odd number or reach the bound
                int rightTempPointer = rightPointer;
                while ((nums[rightPointer++] & 1) == 0 && rightPointer < nums.length) {
                    rightPointer++;
                }
                int rightEvenCount = rightPointer - rightTempPointer;

                // Then count the number of even on the left of window
                int leftEvenCount = 0;
                while ((nums[leftPointer] & 1) == 0) {
                    leftPointer++;
                    leftEvenCount++;
                }

                res += (leftEvenCount + 1) * (rightEvenCount + 1);

                // Notice now leftPointer point to the first odd number in the current window
                // should move rightward 1 to detect further
                leftPointer += 1;
                oddCount -= 1;
            }
        }
        return res;
    }
}
