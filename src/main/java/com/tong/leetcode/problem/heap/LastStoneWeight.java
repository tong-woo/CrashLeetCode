package com.tong.leetcode.problem.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * LeetCode 1046
 * Maximum Heap
 */
public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i : stones) {
            pq.offer(i);
        }

        while (pq.size() > 1) {
            int top1 = pq.poll(), top2 = pq.poll();
            if (top1 != top2) pq.offer(top1 - top2);
        }
        return pq.isEmpty() ? 0 : pq.peek();
    }
}
