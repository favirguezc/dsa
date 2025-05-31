package com.favirguezc.dsa.challenges.recursion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class StaircaseTest {

    @Test
    void testStepPerms() {
        assertEquals(1, Staircase.stepPerms(1));
        assertEquals(4, Staircase.stepPerms(3));
        assertEquals(7, Staircase.stepPerms(4));
        assertEquals(13, Staircase.stepPerms(5));
        assertEquals(44, Staircase.stepPerms(7));
        assertEquals(81, Staircase.stepPerms(8));
        assertEquals(5768, Staircase.stepPerms(15));
        assertEquals(121415, Staircase.stepPerms(20));
        assertEquals(8646064, Staircase.stepPerms(27));
    }

}
