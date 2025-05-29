package com.favirguezc.dsa.challenges.string;

public class SpecialPalindrome {

    public static long substrCount(int n, String s) {
        long count = 0;
        int[] repeated = new int[n];
        int i = 0;
        while (i < n) {
            int repeatedCount = 1;
            int j = i + 1;
            while (j < n && s.charAt(i) == s.charAt(j)) {
                repeatedCount++;
                j++;
            }
            repeated[i] = repeatedCount;
            count += (repeatedCount * (repeatedCount + 1)) / 2;
            i = j;
        }
        for (int k = 1; k < n; k++) {
            if (s.charAt(k) == s.charAt(k - 1)) {
                repeated[k] = repeated[k - 1];
            }
            if (k < n - 1 && (s.charAt(k - 1) == s.charAt(k + 1) && s.charAt(k) != s.charAt(k - 1))) {
                count += Math.min(repeated[k - 1], repeated[k + 1]);
            }
        }

        return count;
    }

    public static long substrCount(String s) {
        return substrCount(s.length(), s);
    }
}