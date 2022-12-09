package com.ho.study.algorithm.koh.recursion;

public class Maze {
    
    private static int N = 8;
    private static int [][] maze = {
            {0, 0, 0, 0, 0, 0, 0, 1},
            {0, 1, 1, 0, 1, 1, 0, 1},
            {0, 0, 0, 1, 0, 0, 0, 1},
            {0, 1, 0, 0, 1, 1, 0, 0},
            {0, 1, 1, 1, 0, 0, 1, 1},
            {0, 1, 0, 0, 0, 1, 0, 1},
            {0, 0, 0, 1, 0, 0, 0, 1},
            {0, 1, 1, 1, 0, 1, 0, 0}
    };

    private static final int PATHWAY_COLOUR = 0;
    private static final int WALL_COLOUR = 1;
    private static final int VISITED_COLOUR = 2;
    private static final int PATH_COLOUR = 3;

    public static void main(String[] args) {
        printMaze();
        boolean isFind = Maze.findMazePath(0, 0);
        printMaze();

        System.out.println(isFind);
    }

    private static boolean findMazePath(int x, int y) {
        if (x < 0 || y < 0 || x >= N || y >= N) {
            return false;
        } else if (maze[x][y] != PATHWAY_COLOUR) {
            return false;
        } else if (x == N-1 && y == N-1) {
            maze[x][y] = PATH_COLOUR;
            return true;
        }

        maze[x][y] = VISITED_COLOUR;
        if (findMazePath(x, y-1) || findMazePath(x-1, y) || findMazePath(x, y+1) || findMazePath(x+1, y)) {
            maze[x][y] = PATH_COLOUR;
            return true;
        }

        return false;
    }

    private static void printMaze() {
        System.out.println("");
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze.length; j++) {
                if (j > 0) {
                    System.out.print(", ");
                }
                System.out.print(maze[i][j]);
            }
            System.out.println("");
        }
    }
}
