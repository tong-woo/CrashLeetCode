package com.tong.leetcode.problem.array;

import java.util.HashSet;
import java.util.Set;

/**
 * LCOF 03. 数组中重复的数字
 * Leetcode 287
 * <a href="https://leetcode.cn/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/">...</a>
 */
public class FindRepeatNumber {
    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (!set.add(i)) return i;
        }
        return 0;
    }

    /**
     * faster by slow, fast pointer, consider the input array as linked list
     * which contains cycle
     * @param nums
     * @return index of
     */
    public int findDuplicate2(int[] nums) {
        int slow = 0, fast = nums[nums[slow]];
        slow = nums[slow];
        while (slow != fast) {
            fast = nums[nums[fast]];
            slow = nums[slow];
        }

        int pre1 = 0;
        int pre2 = slow;

        // pre1, pre2 move backward in step until they meet, that is, the duplicate element
        while (pre2 != pre1) {
            pre1 = nums[pre1];
            pre2 = nums[pre2];
        }
        return pre1;
    }
}
