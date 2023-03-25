package com.tong.leetcode.problem.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://app.codility.com/programmers/lessons/4-counting_elements/missing_integer/">Missing Integer</a>
 */
public class MissingInteger {
    public int solution(int[] A) {
        // Implement your solution here
        int res = 1;
        boolean found = false;
        Set<Integer> hashSet = new HashSet<>();
        for (int i : A) {
            if (i > 0) hashSet.add(i);
        }
        for (int i = 1; i <= A.length + 1 && !found; i++) {
            if (!hashSet.contains(i)) {
                res = i;
                found = true;
            }
        }
        return res;
    }
}
