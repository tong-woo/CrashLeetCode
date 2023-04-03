package com.tong.leetcode.problem.search.binaryserach;

public class RotatedSortedArray {

  public int findMin(int[] nums) {
    int maxRotateTime = nums.length;
    int left = 0;
    int right = maxRotateTime - 1;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] > nums[right]) {
        // like nums = [4,5,6,7,0,1,2],
        // rotate time is not big enough
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return nums[right];
  }
}
