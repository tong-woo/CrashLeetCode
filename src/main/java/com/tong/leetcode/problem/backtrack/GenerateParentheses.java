package com.tong.leetcode.problem.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 22
 * Given n pairs of parentheses,
 * write a function to generate all
 * combinations of well-formed parentheses.
 *
 * @link https://leetcode.cn/problems/generate-parentheses
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        // special judge
        if (n == 0) return List.of();
        // backtrack to collect all possible results
        backtrack("", n, n, result);
        // return
        return result;
    }

    /**
     * Backtrack by Recursion
     * backtrack = Depth-first search in tree + prune function
     * when leftRemain > 0 and rightRemain > 0, branches can be generated
     * when generating left branch, check if there are leftRemain available
     * when generating right branch, check if there are rightRemain available
     * When rightRemain > leftRemain, the branch can be generated
     * When both remain are 0, terminate
     *
     * @param currentString The result String of current recursion
     * @param leftRemain    available number of "("
     * @param rightRemain   available number of ")"
     * @param result        result list
     */
    private void backtrack(String currentString, int leftRemain, int rightRemain, List<String> result) {
        // Terminate condition of the recursion
        if (leftRemain == 0 && rightRemain == 0) {
            result.add(currentString);
            return;
        }
        // pruning to stop backtrack/recursion
        if (leftRemain > rightRemain) return;
        // backtrack/recursion continues
        // generating left branches
        if (leftRemain > 0) backtrack(currentString + "(", leftRemain - 1, rightRemain, result);
        // generating right branches
        if (rightRemain > 0) backtrack(currentString + ")", leftRemain, rightRemain - 1, result);
    }
}
