package com.favirguezc.dsa.challenges.greedy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class GreedyFloristTest {

    @Test
    void testGetMinimumCost() {
        assertEquals(13, GreedyFlorist.getMinimumCost(3, List.of(2, 5, 6)));
        assertEquals(15, GreedyFlorist.getMinimumCost(2, List.of(2, 5, 6)));
        assertEquals(29, GreedyFlorist.getMinimumCost(3, List.of(1, 3, 5, 7, 9)));
    }
}
