package com.tong.leetcode.problem.array;

import java.util.ArrayDeque;
import java.util.Objects;

/**
 * codility training
 * mutation of {@link com.tong.leetcode.problem.array.RotateArray}
 *
 * @see <a href="https://app.codility.com/programmers/lessons/2-arrays/cyclic_rotation/">CyclicRotation</a>
 */
public class CyclicRotation {
    public int[] solution(int[] A, int K) {
        // Implement your solution here
        if (A.length == 0) return A;
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int item : A) {
            queue.offer(item);
        }
        for (int i = 0; i < K; i++) {
            queue.offerFirst(Objects.requireNonNull(queue.pollLast()));
        }
        return queue.stream().mapToInt(Integer::intValue).toArray();
    }
}
