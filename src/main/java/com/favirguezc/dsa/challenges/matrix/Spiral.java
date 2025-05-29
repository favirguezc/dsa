package com.favirguezc.dsa.challenges.matrix;

public class Spiral {

    public static int[] spiral(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] result = new int[rows * cols];
        int index = 0;

        int top = 0;
        int bottom = rows - 1;
        int left = 0;
        int right = cols - 1;

        while (top <= bottom && left <= right) {
            // Traverse from left to right
            for (int i = left; i <= right; i++) {
                result[index++] = matrix[top][i];
            }
            top++;
            // Traverse from top to bottom
            for (int i = top; i <= bottom; i++) {
                result[index++] = matrix[i][right];
            }
            right--;
            if (top <= bottom) {
                // Traverse from right to left
                for (int i = right; i >= left; i--) {
                    result[index++] = matrix[bottom][i];
                }
                bottom--;
            }
            if (left <= right) {
                // Traverse from bottom to top
                for (int i = bottom; i >= top; i--) {
                    result[index++] = matrix[i][left];
                }
                left++;
            }
        }
        return result;
    }
}
