package com.ho.study.algorithm.koh.dp;

public class MatrixChain {
    
    public static void main(String[] args) {
        int arr[] = new int[] { 40, 20, 30, 10, 30 };
        int N = arr.length;
        System.out.println(26000 == MatrixChain.matrixChain(arr, N));

        arr = new int[] { 1, 2, 3, 4, 3 };
        N = arr.length;
        System.out.println(30 == MatrixChain.matrixChain(arr, N));
    }

    private static int matrixChain(int[] p, int n) {
        int m[][] = new int[n][n];

        for (int r = 1; r <= n-1; r++) {
            for (int y = 1; y < n-r; y++) {
                int x = y + r;
                m[y][x] = m[y+1][x] + p[y-1]*p[y]*p[x];
                for (int k = y+1; k <= x-1; k++) {
                    if (m[y][x] > m[y][k] + m[k+1][x] + p[y-1]*p[k]*p[x]) {
                        m[y][x] = m[y][k] + m[k+1][x] + p[y-1]*p[k]*p[x];
                    }
                }
            }
        }

        return m[1][n-1];
    }
}
