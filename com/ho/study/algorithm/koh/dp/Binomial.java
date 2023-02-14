package com.ho.study.algorithm.koh.dp;

public class Binomial {
    
    public static void main(String[] args) {
        System.out.println(10 == Binomial.binomial(5, 2));
        System.out.println(10 == Binomial.binomial(5, 3));
        System.out.println(0 == Binomial.binomial(5, 6));
        System.out.println(0 == Binomial.binomial(5, -1));
        System.out.println(48620 == Binomial.binomial(18, 9));
    }

    private static int binomial(int n, int k) {
        if (k < 0) {
            return 0;
        }

        int[][] binom = new int[n+1][k+1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k && j <= i; j++) {
                if (j == 0 || i == j) {
                    binom[i][j] = 1;
                } else {
                    binom[i][j] = binom[i-1][j-1] + binom[i-1][j];
                }
            }
        }
        return binom[n][k];
    }
}