package com.ho.study.algorithm.koh.recursion;

import java.util.Map;

public class CountCells {

    private static final int[][] grid = {
            {1, 0, 0, 0, 0, 0, 0, 1},
            {0, 1, 1, 0, 0, 1, 0, 0},
            {1, 1, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 1, 0, 0},
            {0, 1, 0, 1, 0, 1, 0, 0},
            {0, 1, 0, 1, 0, 1, 0, 0},
            {1, 0, 0, 0, 1, 0, 0, 1},
            {0, 1, 1, 0, 0, 1, 1, 1}
    };

    private static final int BACKGROUND_COLOR = 0;
    private static final int IMAGE_COLOR = 1;
    private static final int MARK_COLOR = 2;

    public static void main(String[] args) {
        printGrid();
        int size = CountCells.countCells(5, 3);
        printGrid();

        System.out.println(13 == size);
    }

    private static int countCells(int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid.length) {
            return 0;
        } else if (grid[y][x] != IMAGE_COLOR) {
            return 0;
        }

        grid[y][x] = MARK_COLOR;
        return 1 + countCells(x, y+1) + countCells(x+1, y+1) + countCells(x+1, y) + countCells(x+1, y-1) + countCells(x, y-1) + countCells(x-1, y-1) + countCells(x-1, y) + countCells(x-1, y+1);
    }

    private static void printGrid() {
        System.out.println("");

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
}
