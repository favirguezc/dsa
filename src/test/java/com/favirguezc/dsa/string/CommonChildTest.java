package com.favirguezc.dsa.string;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CommonChildTest {

    @Test
    void test1() {
        assertEquals(2, CommonChild.commonChild("HARRY", "SALLY"));
    }

    @Test
    void test2() {
        assertEquals(3, CommonChild.commonChild("ABCD", "ABDC"));
    }

    @Test
    void test3() {
        assertEquals(3, CommonChild.commonChild("SHINCHAN", "NOHARAAA"));
    }
}
