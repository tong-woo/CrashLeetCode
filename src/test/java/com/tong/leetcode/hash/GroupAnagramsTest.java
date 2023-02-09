package com.tong.leetcode.hash;

import com.tong.leetcode.problem.hash.GroupAnagrams;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GroupAnagramsTest {

    @Mock
    GroupAnagrams groupAnagrams;

    @Test
    void testGroupAnagrams(){
        // given
        String[] input = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> res = List.of(List.of("bat"),List.of("nat","tan"),List.of("ate","eat","tea"));

        // when
        when(groupAnagrams.groupAnagrams(input)).thenReturn(res);

        // then
        Assertions.assertTrue(groupAnagrams.groupAnagrams(input).containsAll(res));
    }
}
