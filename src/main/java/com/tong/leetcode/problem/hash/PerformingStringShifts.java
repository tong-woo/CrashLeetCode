package com.tong.leetcode.problem.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode 1427 Performing String shifts
 * Hashmap and shift operation
 */
public class PerformingStringShifts {
    public static String leftShift(String s, int shiftNumber) {
        int shift = shiftNumber % s.length();
        return s.substring(shift) + s.substring(0, shift);
    }

    public static String rightShift(String s, int shiftNumber) {
        int shift = shiftNumber % s.length();
        return s.substring(s.length() - shift) + s.substring(0, s.length() - shift);
    }

    public String stringShift(String s, int[][] shift) {
        Map<Integer, Integer> shiftMap = new HashMap<>();
        int totalLeftShift = 0;
        int totalRightShift = 0;

        for (int[] curShift : shift) {
            if (curShift[0] == 0) shiftMap.put(curShift[0], totalLeftShift += curShift[1]);
            if (curShift[0] == 1) shiftMap.put(curShift[0], totalRightShift += curShift[1]);
        }

        if (shiftMap.get(0) > shiftMap.get(1)) return leftShift(s, shiftMap.get(0) - shiftMap.get(1));
        else if (shiftMap.get(0) < shiftMap.get(1)) return rightShift(s, shiftMap.get(1) - shiftMap.get(0));
        else return s;
    }
}
