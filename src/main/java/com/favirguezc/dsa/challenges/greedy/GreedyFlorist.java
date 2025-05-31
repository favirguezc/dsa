package com.favirguezc.dsa.challenges.greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GreedyFlorist {

    static int getMinimumCost(int k, List<Integer> list) {
        list = new ArrayList<>(list);
        list.sort(Comparator.reverseOrder());
        int cost = 0;
        int p = 0;
        for (int i = 0; i < list.size(); i++) {
            if (i % k == 0) {
                p++;
            }
            cost += list.get(i) * p;
        }
        return cost;
    }
}
