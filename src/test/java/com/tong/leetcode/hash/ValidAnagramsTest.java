package com.tong.leetcode.hash;

import com.tong.leetcode.problem.hash.ValidAnagrams;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidAnagramsTest {

    ValidAnagrams validAnagrams = new ValidAnagrams();

    @Test
    void testValidAnagrams() {
        Assertions.assertTrue(validAnagrams.isAnagram("anagram", "nagaram"));
    }
}
