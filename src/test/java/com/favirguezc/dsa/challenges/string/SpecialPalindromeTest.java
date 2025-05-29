package com.favirguezc.dsa.challenges.string;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SpecialPalindromeTest {

    @Test
    void test1() {
        assertEquals(12, SpecialPalindrome.substrCount("mnonopoo"));
    }

    @Test
    void test2() {
        assertEquals(7, SpecialPalindrome.substrCount("asasd"));
    }

    @Test
    void test3() {
        assertEquals(10, SpecialPalindrome.substrCount("abcbaba"));
    }
}
