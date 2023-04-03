package com.tong.leetcode.problem.binarysearch;

public class SearchMatrix {
    /**
     * faster way by regulation, Binary Search Tree
     * start from right top corner(the root of BST), right to left scan
     * if current > target, we can skip column of current element
     * if current < target, we can skip row of current element
     *
     * @param matrix the 2D array
     * @param target target value
     * @return Boolean
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0, col = matrix[row].length - 1;
        while (row < matrix.length && col >= 0) {
            if (target > matrix[row][col]) row++;
            else if (target < matrix[row][col]) col--;
            else return true;
        }
        return false;
    }

    /**
     * utilize Binary Search since the ascending order
     * slower
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        for (int[] row : matrix) {
            int index = binarySearch(row, target);
            if (index >= 0) return true;
        }
        return false;
    }

    public int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }
}
