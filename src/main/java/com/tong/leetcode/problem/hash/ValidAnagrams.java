package com.tong.leetcode.problem.hash;

import java.util.Arrays;
import java.util.HashMap;

/**
 * LeetCode 242
 * Easy level
 * HashMap
 */
public class ValidAnagrams {
    public boolean isAnagram(String s, String t) {
        HashMap<String, String> anagramMap = new HashMap<>();
        char[] sString = s.toCharArray();
        char[] tString = t.toCharArray();
        Arrays.sort(sString);
        Arrays.sort(tString);
        anagramMap.put(Arrays.toString(sString), s);
        anagramMap.put(Arrays.toString(tString), t);

        return anagramMap.size() == 1;
    }
}
