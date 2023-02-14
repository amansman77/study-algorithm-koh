package com.ho.study.algorithm.koh.dp;

public class MinCostPath {
    
    private static final int START_COLOR = 0;
    private static final int FROM_LEFT_COLOR = 1;
    private static final int FROM_UP_COLOR = 2;

    public static void main(String[] args) {
        int[][] mat = {
            {100, 100, 100, 100, 100},
            {100, 6, 7, 12, 5},
            {100, 5, 3, 11, 18},
            {100, 7, 17, 3, 3},
            {100, 8, 10, 14, 9}
        };
        int[][] pathMat = new int[5][5];

        int cost = MinCostPath.mat(mat, 4, 4, pathMat);
        // printArr(pathMat);
        // printPath(pathMat, 4, 4);
        System.out.println(40 == cost);
    }

    private static void printPath(int[][] pathMat, int x, int y) {
        if (x == 1 && y == 1) {
            System.out.println(x + ", " + y);
            return;
        } else {
            if (pathMat[y][x] == FROM_LEFT_COLOR) {
                printPath(pathMat, x-1, y);
            } else {
                printPath(pathMat, x, y-1);
            }
            System.out.println(x + ", " + y);
        }
    }

    private static int mat(int[][] mat, int n, int m, int[][] pathMat) {
        int[][] L = new int[m+1][n+1];
        for (int i = 0; i < m+1; i++) {
            L[i][0] = 100;
        }
        for (int i = 0; i < n+1; i++) {
            L[0][i] = 100;
        }

        for (int y = 1; y <= m; y++) {
            for (int x = 1; x <= n; x++) {
                if (x == 1 && y == 1) {
                    L[y][x] = mat[1][1];
                    pathMat[y][x] = START_COLOR;
                } else {
                    if (L[y-1][x] < L[y][x-1]) {
                        L[y][x] = mat[y][x] + L[y-1][x];
                        pathMat[y][x] = FROM_UP_COLOR;
                    } else {
                        L[y][x] = mat[y][x] + L[y][x-1];
                        pathMat[y][x] = FROM_LEFT_COLOR;
                    }
                }
            }
        }

        // printArr(L);
        
        return L[m][n];
    }

    private static void printArr(int[][] arr) {
        for (int y = 0; y < arr.length; y++) {
            System.out.println();
            for (int x = 0; x < arr[0].length; x++) {
                if (x > 0) {
                    System.out.print(", ");
                }
                System.out.print(arr[y][x]);
            }
        }
        System.out.println();
    }
}