package com.tong.leetcode.problem.heap;

import java.util.*;

/**
 * LeetCode 2512
 * Solve this by Heap(Priority Queue) and self-defined class
 * @link https://leetcode.com/problems/reward-top-k-students/description/
 */
public class RewardTopKStudents {

    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_Id, int k) {

        HashMap<String, Integer> positiveScoreMap = new HashMap<>(), negativeScoreMap = new HashMap<>();
        int count = 0;

        for (String s : positive_feedback) {
            positiveScoreMap.put(s, 3);
        }

        for (String s : negative_feedback) {
            negativeScoreMap.put(s, -1);
        }

        PriorityQueue<IdScorePair> priorityQueue= new PriorityQueue<>((a, b) -> {
            if (a.score == b.score) return a.Id - b.Id;
            return b.score - a.score;
        });

        for (String currentReport : report) {
            String[] currentReportArray = currentReport.split(" ");
            int score = 0;
            for (String s : currentReportArray) {
                if (positiveScoreMap.containsKey(s)) score += positiveScoreMap.get(s);
                if (negativeScoreMap.containsKey(s)) score += negativeScoreMap.get(s);
            }
            priorityQueue.offer(new IdScorePair(student_Id[count], score));
            count++;
        }

        List<Integer> result=new ArrayList<>();
        while(k>0){
            result.add(Objects.requireNonNull(priorityQueue.poll()).Id);
            k--;
        }
        return result;
    }

    static class IdScorePair {
        int Id;
        int score;

        IdScorePair(int Id, int score){
            this.Id = Id;
            this.score = score;
        }
    }
}


