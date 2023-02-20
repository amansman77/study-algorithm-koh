package com.ho.study.algorithm.koh.dp;

public class Knapsack {
    
    public static void main(String[] args) {
        int[] values = {1, 2, 3};
        int[] weight = {4, 5, 1};
        int N = values.length;
        int W = 4;
        System.out.println(3 == Knapsack.knapsack(values, weight, N, W));

        values = new int[]{1, 2, 3};
        weight = new int[]{4, 5, 6};
        N = values.length;
        W = 3;
        System.out.println(0 == Knapsack.knapsack(values, weight, N, W));
    }

    private static int knapsack(int[] values, int[] weight, int n, int w) {
        int[][] M = new int[n + 1][w + 1];

        for (int y = 1; y <= n; y++) {
            for (int x = 1; x <= w; x++) {
                if (weight[y-1] > w) {
                    M[y][w] = M[y-1][w];
                } else {
                    M[y][w] = Math.max(M[y-1][w], values[y-1] + M[y-1][w-weight[y-1]]);
                }
            }
        }

        return M[n][w];
    }
}
