package com.tong.leetcode.heap;

import com.tong.leetcode.problem.heap.KHighestRankedItemsWithinRange;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class KHighestRankedItemsWithinRangeTest {

    @Mock
    KHighestRankedItemsWithinRange kHighestRankedItemsWithinRange = new KHighestRankedItemsWithinRange();

    @Test
    void testKHighestRankedItemsWithinRange(){
        List<List<Integer>> result = List.of(List.of(0,1), List.of(1,1), List.of(2,1));
        int[][] grid = {{1,2,0,1},{1,3,0,1},{0,2,5,1}};
        int[] pricing = {2,5};
        int[] start = {0,0};
        int k = 3;

        Assertions.assertThat(kHighestRankedItemsWithinRange.highestRankedKItems(grid, pricing, start, k))
                .isEqualTo(result);
    }
}
