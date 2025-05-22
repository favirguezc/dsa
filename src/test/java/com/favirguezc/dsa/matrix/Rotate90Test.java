package com.favirguezc.dsa.matrix;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Rotate90Test {

    @Test
    void testRotate1x1Matrix() {
        int[][] matrix = { { 1 } };
        int[][] expected = { { 1 } };
        Rotate90.rotate(matrix);
        assertArrayEquals(expected, matrix);
    }

    @Test
    void testRotate2x2Matrix() {
        int[][] matrix = {
                { 1, 2 },
                { 3, 4 }
        };
        int[][] expected = {
                { 3, 1 },
                { 4, 2 }
        };
        Rotate90.rotate(matrix);
        assertArrayEquals(expected, matrix);
    }

    @Test
    void testRotate3x3Matrix() {
        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        int[][] expected = {
                { 7, 4, 1 },
                { 8, 5, 2 },
                { 9, 6, 3 }
        };
        Rotate90.rotate(matrix);
        assertArrayEquals(expected, matrix);
    }

    @Test
    void testRotate4x4Matrix() {
        int[][] matrix = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 }
        };
        int[][] expected = {
                { 13, 9, 5, 1 },
                { 14, 10, 6, 2 },
                { 15, 11, 7, 3 },
                { 16, 12, 8, 4 }
        };
        Rotate90.rotate(matrix);
        assertArrayEquals(expected, matrix);
    }

    @Test
    void testRotate5x5Matrix() {
        int[][] matrix = {
                { 1, 2, 3, 4, 5 },
                { 6, 7, 8, 9, 10 },
                { 11, 12, 13, 14, 15 },
                { 16, 17, 18, 19, 20 },
                { 21, 22, 23, 24, 25 }
        };
        int[][] expected = {
                { 21, 16, 11, 6, 1 },
                { 22, 17, 12, 7, 2 },
                { 23, 18, 13, 8, 3 },
                { 24, 19, 14, 9, 4 },
                { 25, 20, 15, 10, 5 }
        };
        Rotate90.rotate(matrix);
        assertArrayEquals(expected, matrix);
    }

    @Test
    void testRotateMatrixWithNegativeNumbers() {
        int[][] matrix = {
                { -1, -2 },
                { -3, -4 }
        };
        int[][] expected = {
                { -3, -1 },
                { -4, -2 }
        };
        Rotate90.rotate(matrix);
        assertArrayEquals(expected, matrix);
    }

    @Test
    void testRotateMatrixWithZeros() {
        int[][] matrix = {
                { 0, 0, 0 },
                { 0, 0, 0 },
                { 0, 0, 0 }
        };
        int[][] expected = {
                { 0, 0, 0 },
                { 0, 0, 0 },
                { 0, 0, 0 }
        };
        Rotate90.rotate(matrix);
        assertArrayEquals(expected, matrix);
    }

    @Test
    void testRotateMatrixTwiceReturns180DegreeRotation() {
        int[][] matrix = {
                { 1, 2 },
                { 3, 4 }
        };
        int[][] expected = {
                { 4, 3 },
                { 2, 1 }
        };
        Rotate90.rotate(matrix);
        Rotate90.rotate(matrix);
        assertArrayEquals(expected, matrix);
    }

    @Test
    void testRotateMatrixFourTimesReturnsOriginal() {
        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        int[][] original = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        for (int i = 0; i < 4; i++) {
            Rotate90.rotate(matrix);
        }
        assertArrayEquals(original, matrix);
    }

    @Test
    void testRotateEmptyMatrix() {
        int[][] matrix = new int[0][0];
        int[][] expected = new int[0][0];
        Rotate90.rotate(matrix);
        assertArrayEquals(expected, matrix);
    }
}
