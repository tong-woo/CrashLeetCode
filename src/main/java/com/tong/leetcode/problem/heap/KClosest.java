package com.tong.leetcode.problem.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * LeetCode 973
 * <a href="https://leetcode.com/problems/k-closest-points-to-origin/">...</a>
 */
public class KClosest {
    public int[][] kClosest(int[][] points, int k) {
        int[][] res = new int[k][2];
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (int) (Math.pow(o1[0], 2) + Math.pow(o1[1], 2) - Math.pow(o2[0], 2) - Math.pow(o2[1], 2));
            }
        });
        for (int[] i : points) {
            pq.offer(i);
        }
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }
        return res;
    }
}
