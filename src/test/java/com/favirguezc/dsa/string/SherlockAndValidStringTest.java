package com.favirguezc.dsa.string;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SherlockAndValidStringTest {

    @Test
    void test1() {
        assertEquals("YES", SherlockAndValidString.isValid("aabbc"));
    }

    @Test
    void test2() {
        assertEquals("NO", SherlockAndValidString.isValid("aabbcd"));
    }

    @Test
    void test3() {
        assertEquals("NO", SherlockAndValidString.isValid("aabbccddeefghi"));
    }

    @Test
    void test4() {
        assertEquals("YES", SherlockAndValidString.isValid("abcdefghhgfedecba"));
    }

    @Test
    void test5() {
        assertEquals("NO", SherlockAndValidString.isValid(""));
    }
}
