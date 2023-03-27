package com.tong.leetcode.problem.array;

import java.util.*;

public class TopKFrequent {
    /**
     * Method 1: minimum heap with map
     *
     * @param nums
     * @param k
     * @return int[]
     */
    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == 1) return nums;
        HashSet<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (!set.add(i)) map.put(i, map.get(i) + 1);
            else map.put(i, 1);
        }
        // minimum heap a - b, the element at the top is the smallest
        // maximum heap b - 1, ...
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return map.get(a) - map.get(b);
            }
        });

        for (int key : map.keySet()) {
            if (pq.size() < k) pq.add(key);
            else if (map.get(key) > map.get(pq.peek())) {
                pq.remove();
                pq.add(key);
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.remove());
        }

        return res.stream().mapToInt(i -> i).toArray();
    }

    /**
     * Method 2: faster by radix sort with map,
     * array operation is much faster than priority queue
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent2(int[] nums, int k) {
        if (nums.length == 1) return nums;
        List<Integer> res = new ArrayList<>();
        List[] list = new List[nums.length + 1];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        // minimum heap a - b, the element at the top is the smallest
        // maximum heap b - 1, ...
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return map.get(a) - map.get(b);
            }
        });

        // array operation is much faster than priority queue
        for (int key : map.keySet()) {
            // get the times as index
            int i = map.get(key);
            if (list[i] == null) {
                list[i] = new ArrayList<>();
            }
            list[i].add(key);
        }

        // reversely iterate the array to get top k
        for (int i = list.length - 1; i >= 0 && res.size() < k; i--) {
            if (list[i] == null) continue;
            res.addAll(list[i]);
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
}
