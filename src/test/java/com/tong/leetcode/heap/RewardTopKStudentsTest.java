package com.tong.leetcode.heap;

import com.tong.leetcode.problem.heap.RewardTopKStudents;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;
import java.util.stream.IntStream;

public class RewardTopKStudentsTest {

    @Mock
    RewardTopKStudents rewardTopKStudents = new RewardTopKStudents();

    @Test
    void testRewardTopKStudents(){
        String [] positiveFeedback = {"smart","brilliant","studious"};
        String [] negativeFeedback = {"not"};
        String [] report = {"this student is studious","the student is smart"};
        int [] id = IntStream.of(1,2).toArray();
        int k = 2;
        Assertions.assertThat(rewardTopKStudents.topStudents(positiveFeedback, negativeFeedback, report, id, k))
                .isEqualTo(List.of(1,2));
    }
}
