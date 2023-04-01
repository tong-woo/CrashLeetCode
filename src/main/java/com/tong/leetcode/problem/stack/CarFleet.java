package com.tong.leetcode.problem.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CarFleet {

  /**
   * LeetCode 853. Car Fleet
   * <p>
   * Sort the fleet based on their position to the target destination For adjacent two cars A and B,
   * if A.position > B.Position and B's timeTpTarget is smaller than A's timeTpTarget, then A and B
   * can form a car fleet for sure. Otherwise, if B's timeTpTarget is bigger, it will form a
   * separate fleet.
   */
  public int carFleet(int target, int[] position, int[] speed) {
    if (position.length == 1) {
      return 1;
    }
    List<Car> lane = new ArrayList<>();
    Stack<Double> stack = new Stack<>();
    // decide if two car fleets can meet each other
    for (int i = 0; i < position.length; i++) {
      lane.add(new Car(position[i], speed[i]));
    }
    lane.sort((o1, o2) -> o2.position - o1.position);
    // maintain an increasing stack with the time to target as the element
    // time to target can represent different car fleets
    for (Car car : lane) {
      double timeToTarget = (target - car.position) * 1.0d / car.speed;
      if (!stack.isEmpty() && stack.peek() >= timeToTarget) {
        // no operation since skip the current car
        // and merge to the same car fleet as the peek of stack
      } else {
        stack.push(timeToTarget);
      }
    }
    return stack.size();
  }

  static class Car {

    private final int position;
    private final int speed;

    public Car(int pos, int speed) {
      this.position = pos;
      this.speed = speed;
    }
  }
}
