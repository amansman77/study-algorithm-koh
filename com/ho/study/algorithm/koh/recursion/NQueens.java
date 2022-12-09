package com.ho.study.algorithm.koh.recursion;

public class NQueens {
    
    private static final int GRID_SIZE = 8;

    public static void main(String[] args) {
        int[] path = new int[GRID_SIZE + 1];
        boolean isSuccess = NQueens.queens(path, 0);

        System.out.println(isSuccess);
        if (isSuccess) {
            System.out.println("");
            printPath(path);
            printGraph(path);
        }
    }

    private static void printGraph(int[] path) {
        System.out.println("");

        int[][] grid = new int[GRID_SIZE][GRID_SIZE];
        for (int i = 0; i < grid.length; i++) {
            grid[i][path[i+1]-1] = 1;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (j > 0) {
                    System.out.print(", ");
                }
                System.out.print(grid[i][j]);
            }
            System.out.println("");
        }
    }

    private static void printPath(int[] path) {
        for (int i = 0; i < path.length; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(path[i]);
        }
        System.out.println("");
    }

    private static boolean queens(int[] path, int level) {
        if (!promising(path, level)) {
            return false;
        } else if (level == GRID_SIZE) {
            return true;
        }
        for (int i = 1; i <= GRID_SIZE; i++) {
            path[level+1] = i;
            if (queens(path, level + 1)) {
                return true;
            }
        }
        return false;
    }

    private static boolean promising(int[] path, int level) {
        for (int i = 1; i < level; i++) {
            if (path[i] == path[level]) {
                return false;
            }

            if ((level - i) == (Math.abs(path[level] - path[i]))) {
                return false;
            }
        }

        return true;
    }
}
