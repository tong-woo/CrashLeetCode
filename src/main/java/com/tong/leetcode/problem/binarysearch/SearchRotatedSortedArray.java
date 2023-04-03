package com.tong.leetcode.problem.binarysearch;

import java.util.Arrays;

public class SearchRotatedSortedArray {

  /**
   * LeetCode 33. Search in Rotated Sorted Array
   */
  public int search(int[] nums, int target) {
    int start = 0;
    int end = nums.length - 1;
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (nums[mid] == target) {
        return mid;
      }
      // pre half is ordered
      if (nums[start] <= nums[mid]) {
        // target is in pre half
        if (target >= nums[start] && target < nums[mid]) {
          end = mid - 1;
        } else {
          start = mid + 1;
        }
      } else {
        if (target <= nums[end] && target > nums[mid]) {
          start = mid + 1;
        } else {
          end = mid - 1;
        }
      }
    }
    return -1;
  }

  /**
   * My solution Search two sorted arrays
   *
   * @param nums
   * @param target
   * @return
   */
  public int search2(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] > nums[right]) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    int resLeft = binarySearch(Arrays.copyOfRange(nums, 0, right), target);
    int resRight = binarySearch(Arrays.copyOfRange(nums, right, nums.length), target);
    if (resLeft == -1) {
      return resRight == -1 ? resRight : resRight + right;
    }
    return resLeft;
  }

  public int binarySearch(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] > target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return -1;
  }
}
