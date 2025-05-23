package com.favirguezc.dsa.array;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MinimumSwapsOrderedArrayTest {

    @Test
    void test1() {
        int[] arr = { 7, 1, 3, 2, 4, 5, 6 };
        int result = MinimumSwapsOrderedArray.minimumSwaps(arr);
        assertEquals(5, result);
    }

    @Test
    void test2() {
        int[] arr = { 4, 3, 1, 2 };
        int result = MinimumSwapsOrderedArray.minimumSwaps(arr);
        assertEquals(3, result);
    }

    @Test
    void test3() {
        int[] arr = { 2, 3, 4, 1, 5 };
        int result = MinimumSwapsOrderedArray.minimumSwaps(arr);
        assertEquals(3, result);
    }

    @Test
    void test4() {
        int[] arr = { 1, 3, 5, 2, 4, 6, 7 };
        int result = MinimumSwapsOrderedArray.minimumSwaps(arr);
        assertEquals(3, result);
    }
}
