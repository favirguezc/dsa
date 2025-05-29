package com.favirguezc.dsa.challenges.string;

public class CommonChild {

    public static int commonChild(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    // char match, add 1 to the previous diagonal value
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    // char mismatch, take the max of the left and top values
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        return dp[n][m];
    }
}
