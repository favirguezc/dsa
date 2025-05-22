package com.favirguezc.dsa.matrix;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SpiralTest {

    @Test
    void testEmptyMatrix() {
        int[][] matrix = new int[0][0];
        int[] expected = new int[0];
        assertArrayEquals(expected, Spiral.spiral(matrix));
    }

    @Test
    void testNullMatrix() {
        int[] expected = new int[0];
        assertArrayEquals(expected, Spiral.spiral(null));
    }

    @Test
    void test1x1Matrix() {
        int[][] matrix = { { 1 } };
        int[] expected = { 1 };
        assertArrayEquals(expected, Spiral.spiral(matrix));
    }

    @Test
    void test1xNMatrix() {
        int[][] matrix = { { 1, 2, 3, 4 } };
        int[] expected = { 1, 2, 3, 4 };
        assertArrayEquals(expected, Spiral.spiral(matrix));
    }

    @Test
    void testNx1Matrix() {
        int[][] matrix = {
                { 1 },
                { 2 },
                { 3 },
                { 4 }
        };
        int[] expected = { 1, 2, 3, 4 };
        assertArrayEquals(expected, Spiral.spiral(matrix));
    }

    @Test
    void test2x2Matrix() {
        int[][] matrix = {
                { 1, 2 },
                { 3, 4 }
        };
        int[] expected = { 1, 2, 4, 3 };
        assertArrayEquals(expected, Spiral.spiral(matrix));
    }

    @Test
    void test3x3Matrix() {
        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        int[] expected = { 1, 2, 3, 6, 9, 8, 7, 4, 5 };
        assertArrayEquals(expected, Spiral.spiral(matrix));
    }

    @Test
    void test4x4Matrix() {
        int[][] matrix = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 }
        };
        int[] expected = { 1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10 };
        assertArrayEquals(expected, Spiral.spiral(matrix));
    }

    @Test
    void testRectangularMatrixMoreRows() {
        int[][] matrix = {
                { 1, 2 },
                { 3, 4 },
                { 5, 6 }
        };
        int[] expected = { 1, 2, 4, 6, 5, 3 };
        assertArrayEquals(expected, Spiral.spiral(matrix));
    }

    @Test
    void testRectangularMatrixMoreCols() {
        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 }
        };
        int[] expected = { 1, 2, 3, 6, 5, 4 };
        assertArrayEquals(expected, Spiral.spiral(matrix));
    }

    @Test
    void testMatrixWithNegativeNumbers() {
        int[][] matrix = {
                { -1, -2 },
                { -3, -4 }
        };
        int[] expected = { -1, -2, -4, -3 };
        assertArrayEquals(expected, Spiral.spiral(matrix));
    }

    @Test
    void testMatrixWithZeros() {
        int[][] matrix = {
                { 0, 0 },
                { 0, 0 }
        };
        int[] expected = { 0, 0, 0, 0 };
        assertArrayEquals(expected, Spiral.spiral(matrix));
    }

    @Test
    void testJaggedMatrixThrowsError() {
        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5 }
        };
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> Spiral.spiral(matrix));
    }
}
