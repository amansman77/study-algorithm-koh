package com.ho.study.algorithm.koh.dp;

public class LongestCommonSubsequence {
    
    public static void main(String[] args) {
        String first = "ABCDGH";
        String second = "AEDFHR";
        int[][] c = new int[first.length()+1][second.length()+1];
        System.out.println(3 == LongestCommonSubsequence.lcs(c, first, second));

        first = "AGGTAB";
        second = "GXTXAYB";
        c = new int[first.length()+1][second.length()+1];
        System.out.println(4 == LongestCommonSubsequence.lcs(c, first, second));
    }

    private static int lcs(int[][] c, String first, String second) {

        for (int y = 1; y <= first.length(); y++) {
            for (int x = 1; x <= second.length(); x++) {
                if (first.charAt(y-1) == second.charAt(x-1)) {
                    c[y][x] = c[y-1][x-1] + 1;
                } else {
                    c[y][x] = Math.max(c[y-1][x], c[y][x-1]);
                }
            }
        }
        return c[first.length()][second.length()];
    }
}