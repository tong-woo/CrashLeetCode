package com.tong.leetcode.problem.bitmanipulation;

/**
 * LeetCode 868
 * Bit manipulation with right movement
 * Left move -> multiply 2
 * right move -> divide 2
 *
 * @link https://leetcode.cn/problems/binary-gap/
 */
public class BinaryGap {
    public int binaryGap(int n) {
        int res = 0;
        for (int i = 31, j = -1; i >= 0; i--) {
            if (((n >> i) & 1) == 1) {
                if (j != -1) res = Math.max(res, j - i);
                j = i;
            }
        }
        return res;
    }
}
