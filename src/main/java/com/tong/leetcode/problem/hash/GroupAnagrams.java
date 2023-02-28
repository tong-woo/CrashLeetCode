package com.tong.leetcode.problem.hash;

import java.util.*;

/**
 * Given an array of strings strs, group the anagrams together.
 * An Anagram is a word or phrase formed by rearranging
 * the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 * <p>
 * HashMap problem
 * <p>
 * LeetcCode 49
 *
 * @link https://leetcode.cn/problems/group-anagrams/description/
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramsMap = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!anagramsMap.containsKey(key)) anagramsMap.put(key, new ArrayList<>());
            anagramsMap.get(key).add(str);
        }

        return new ArrayList<>(anagramsMap.values());
    }
}
