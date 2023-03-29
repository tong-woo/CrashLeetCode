package com.tong.leetcode.problem.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * LeetCode 215 Given an integer array nums and an integer k, return the kth largest element in the
 * array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * You must solve it in O(n) time complexity.
 * <p>
 * <a href="https://leetcode.cn/problems/kth-largest-element-in-an-array/">...</a>
 */
public class FindKthLargest {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i : nums) {
            pq.offer(i);
        }
        while (pq.size() > nums.length - k + 1) {
            pq.poll();
        }
        return pq.peek();
    }

    public int findKthLargest2(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
