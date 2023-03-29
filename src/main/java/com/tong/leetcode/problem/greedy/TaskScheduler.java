package com.tong.leetcode.problem.greedy;

/**
 * LeetCode 621
 * <a href="https://leetcode.cn/problems/task-scheduler/">...</a>
 */
public class TaskScheduler {
  /**
   * Construct model to solve the problem
   * greedy algorithm, firstly distribute the task appears the most
   * maxCount: the number of the task which appears the most
   * maxTime:  the number of the tasks which appears the same time as
   *           the task with maxCount
   */
  public int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];
        // count the number of same chars
        for (char task:tasks) counts[task-'A']++;
        int maxCount = 0, maxTime = 0;
        for (int i = 0; i<26; i++) maxCount = Math.max(maxCount, counts[i]);
        for (int i = 0; i<26; i++) maxTime += maxCount == counts[i] ? 1:0;
        return Math.max(tasks.length, (n + 1) * (maxCount - 1) + maxTime);
  }
}
