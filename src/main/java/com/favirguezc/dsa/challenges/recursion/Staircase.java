package com.favirguezc.dsa.challenges.recursion;

import java.util.HashMap;
import java.util.Map;

public class Staircase {

    private static Map<Integer, Long> memo = new HashMap<>();
    static {
        memo.put(1, 1L);
        memo.put(2, 2L);
        memo.put(3, 4L);
    }

    public static int stepPerms(int n) {
        if (n <= 0) {
            return 0;
        }
        if (memo.containsKey(n)) {
            return (int) (memo.get(n) % 10000000007L);
        }
        long steps = stepPerms(n - 1) + stepPerms(n - 2) + stepPerms(n - 3);
        memo.put(n, steps);
        return (int) (steps % 10000000007L);
    }
}
