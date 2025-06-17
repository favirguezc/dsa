package com.favirguezc.dsa.challenges.array;

public class MaxDifferenceBetweenIncreasingElements {

    /*
     * Given a 0-indexed integer array nums of size n, find the maximum difference
     * between nums[i] and nums[j] (i.e., nums[j] - nums[i]), such that 0 <= i < j <
     * n and nums[i] < nums[j].
     * 
     * Return the maximum difference. If no such i and j exists, return -1.
     */
    public static int maximumDifference(int[] nums) {
        int maxDiff = -1;
        int min = Integer.MAX_VALUE;
        if (nums.length > 0) {
            min = nums[0];
        }
        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            if (curr < min) {
                min = curr;
            } else if (curr > min && curr - min > maxDiff) {
                maxDiff = curr - min;
            }
        }
        return maxDiff;
    }
}
