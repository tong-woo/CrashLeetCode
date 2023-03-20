package com.tong.leetcode.problem.bitmanipulation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Codility training
 * mutation of Leetcode 136
 *
 * @link <a href="https://leetcode.cn/problems/single-number/">single number</a>
 */
public class OddOccurrencesInArray {
    /**
     * Map way O(n)
     */
    public int solution1(int[] A) {
        // Implement your solution here
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.sort(A);
        for (int i : A) {
            if (!map.containsKey(i)) map.put(i, 1);
            else map.put(i, map.get(i) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) res = entry.getKey();
        }
        return res;
    }

    /**
     * Bit manipulation way O(1)
     * 如果a、b两个值不相同，则异或结果为1。如果a、b两个值相同，异或结果为0
     * 0 XOR a = a, a XOR a = 0
     * a ⊕ b ⊕ a = b ⊕ a ⊕ a = b ⊕ (a ⊕ a) = b ⊕ 0 = b
     * (a1 ⊕ a1) ⊕ (a2 ⊕ a2) ⊕ ⋯ ⊕ (am ⊕ am) ⊕ am+1 = 0 ⊕ 0 ⊕ ⋯ ⊕ am+1 = am+1
     */
    public int solution2(int[] A) {
        // Implement your solution here
        int res = 0;
        for (int num : A) {
            res ^= num;
        }
        return res;
    }
}
