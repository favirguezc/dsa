package com.favirguezc.dsa.challenges.array;

import java.util.HashMap;

public class MinimumSwapsOrderedArray {

    private static void swap(int[] arr, int i1, int i2) {
        int t = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = t;
    }

    /*
     * Given an unordered array consisting of consecutive integers [1, 2, 3, ..., n]
     * without any duplicates. You are allowed to swap any two elements. Find the
     * minimum number of swaps required to sort the array in ascending order.
     */
    public static int minimumSwaps(int[] arr) {
        int n = arr.length;
        int swaps = 0;
        HashMap<Integer, Integer> currentPositions = new HashMap<>();
        for (int i = 0; i < n; i++) {
            currentPositions.put(arr[i], i);
        }
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] != i + 1) {
                int currentPosition = currentPositions.get(i + 1);
                swap(arr, i, currentPosition);
                currentPositions.put(arr[currentPosition], currentPosition);
                currentPositions.put(arr[i], i);
                swaps++;
            }
        }
        return swaps;
    }
}
