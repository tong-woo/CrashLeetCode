package com.tong.leetcode.problem.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 * <p>
 * LeetCode 703
 *
 * @link https://leetcode.cn/problems/kth-largest-element-in-a-stream/
 */
public class KthLargest {
    int k;
    PriorityQueue<Integer> pq;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.pq = new PriorityQueue<>();
        Arrays.stream(nums).forEach(num -> this.pq.offer(num));
    }

    public int add(int val) {
        pq.offer(val);
        while (pq.size() > k) pq.poll();
        return pq.peek();
    }
}
