package com.ho.study.algorithm.koh.sort;

public class Radix {
    
    private static final int D = 3;
    public static void main(String[] args) {
        int[][] dataArr = {
            {329, 457, 657, 839, 436, 720, 355}
        };

        for (int[] data : dataArr) {
            Radix.sort(data);
    
            printArr(data);
        }
    }

    private static void sort(int[] data) {
        for (int i = 0; i < D; i++) {
            for (int j = 0; j < data.length; j++) {
                Counting.sort(data, 10, D, i+1);
            }
        }
    }

    private static void printArr(int[] data) {
        System.out.println();
        for (int i = 0; i < data.length; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(data[i]);
        }
    }
}
