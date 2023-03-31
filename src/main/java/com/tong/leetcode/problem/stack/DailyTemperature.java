package com.tong.leetcode.problem.stack;

import java.util.Stack;

/**
 * LeetCode 739 monopoly decreasing stack
 * <a href="https://leetcode.cn/problems/daily-temperatures">...</a>
 */
public class DailyTemperature {

  /**
   * decreasing stack solution
   * stack stores teh index rather than temperatures
   */
  public int[] dailyTemperatures(int[] temperatures) {
    int[] res = new int[temperatures.length];
    Stack<Integer> decreaseStack = new Stack<>();
    for (int i = 0; i < temperatures.length; i++) {
      int degree = temperatures[i];
      if (decreaseStack.isEmpty()) {
        decreaseStack.push(i);
      }
      while (!decreaseStack.isEmpty() && degree > temperatures[decreaseStack.peek()]) {
        int topIndex = decreaseStack.pop();
        res[topIndex] = i - topIndex;
      }
      decreaseStack.push(i);
    }
    return res;
  }

  /**
   * out of time method...
   */
  public int[] dailyTemperatures2(int[] temperatures) {
    int[] res = new int[temperatures.length];
    for (int i = 0; i < temperatures.length; i++) {
      for (int start = i + 1; start < temperatures.length; start++) {
        if (temperatures[start] > temperatures[i]) {
          res[i] = start - i;
          break;
        } else {
          res[i] = 0;
        }
      }
    }
    return res;
  }
}
