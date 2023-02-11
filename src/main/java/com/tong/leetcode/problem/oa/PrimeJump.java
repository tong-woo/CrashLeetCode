package com.tong.leetcode.problem.oa;

import java.util.ArrayList;
import java.util.List;

/**
 * Prime Jump
 * Not solved yet
 */
public class PrimeJump {
    public static int maxGameScore(List<Integer> cell) {
        int ans = 0, score = 0, range = cell.size();
        List<Integer> primeMoveList = new ArrayList<>();
        // possible prime moves with least num 3
        for (int i=0; i<range; i++){
            if (isPrimeWithLeastSignificant3(i)){
                primeMoveList.add(i);
            }
        }
        return 0;
    }

    static class Cell{

    }

    static boolean isPrimeWithLeastSignificant3 (int n)
    {
        // 0, 1 negative numbers are not prime
        if (n < 2)
            return false;
        // checking the number of divisors b/w 1 and the number n-1
        for (int i = 2; i < n; i++)
        {
            if (n % i == 0)
                return false;
        }
        // if reached here then must be true
        return n % 10 == 3;
    }
}
