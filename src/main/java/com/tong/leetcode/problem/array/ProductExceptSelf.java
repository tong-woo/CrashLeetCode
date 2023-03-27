package com.tong.leetcode.problem.array;

/**
 * LeetCode 238
 * split the computation to a matrix with upper triangle and
 * lower triangle, the diagonal is all 1
 * More about math...
 */
public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int counterUpperTriangle = 1, counterLowerTriangle = 1;
        for (int i=0; i<nums.length; i++){
            res[i] = counterUpperTriangle;
            counterUpperTriangle *= nums[i];
        }
        for (int i=nums.length-1; i>0; i--){
            counterLowerTriangle *= nums[i];
            res[i-1] *= counterLowerTriangle;
        }
        return res;
    }
}
