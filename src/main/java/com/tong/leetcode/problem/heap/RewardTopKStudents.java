package com.tong.leetcode.problem.heap;

import lombok.AllArgsConstructor;

import java.util.*;

/**
 * LeetCode 2512
 * Solve this by Heap(Priority Queue) and self-defined class
 * @link https://leetcode.com/problems/reward-top-k-students/description/
 */
public class RewardTopKStudents {

    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {

        HashMap<String, Integer> positiveScoreMap = new HashMap<>(), negativeScoreMap = new HashMap<>();
        int count = 0;

        for (String s : positive_feedback) {
            positiveScoreMap.put(s, 3);
        }

        for (String s : negative_feedback) {
            negativeScoreMap.put(s, -1);
        }

        PriorityQueue<IDScorePair> priorityQueue= new PriorityQueue<>((a, b) -> {
            if (a.score == b.score) return a.id - b.id;
            return b.score - a.score;
        });

        for (String currentReport : report) {
            String[] currentReportArray = currentReport.split(" ");
            int score = 0;
            for (String s : currentReportArray) {
                if (positiveScoreMap.containsKey(s)) score += positiveScoreMap.get(s);
                if (negativeScoreMap.containsKey(s)) score += negativeScoreMap.get(s);
            }
            priorityQueue.offer(new IDScorePair(student_id[count], score));
            count++;
        }

        List<Integer> result=new ArrayList<>();
        while(k>0){
            result.add(Objects.requireNonNull(priorityQueue.poll()).id);
            k--;
        }
        return result;
    }

    static class IDScorePair {
        int id;
        int score;

        IDScorePair(int id, int score){
            this.id = id;
            this.score = score;
        }
    }
}


