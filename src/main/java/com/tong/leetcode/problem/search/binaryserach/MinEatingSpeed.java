package com.tong.leetcode.problem.search.binaryserach;

import java.util.Arrays;

/**
 * LeetCode 875. Koko Eating Bananas
 * <p>
 * binary search problem find min and max value of speed, then find the target speed under the
 * constraint
 */
public class MinEatingSpeed {

  public int minEatingSpeed(int[] piles, int h) {
    int maxPileNum = Arrays.stream(piles).max().getAsInt();
    int left = 1;
    // biggest speed equals to the max pile number
    int right = maxPileNum;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (timeToFinish(piles, mid) > h) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    // left == right in the end
    return right;
  }

  private int timeToFinish(int[] piles, int speed) {
    int sum = 0;
    for (int pile : piles) {
      sum += Math.ceil(1.0d * pile / speed);
    }
    return sum;
  }
}
