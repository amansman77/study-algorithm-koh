package com.ho.study.algorithm.koh.sort;

public class Bubble {
    
    public static void main(String[] args) {
        int[][] dataArr = {
            {1, 2, 3, 2, 1},
            {1, 2, 3, 5, 1},
            {29, 10, 14, 37, 13}
        };

        for (int[] data : dataArr) {
            Bubble.sort(data);
    
            printArr(data);
        }
    }

    private static void sort(int[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - 1; j++) {
                if (data[j] > data[j + 1]) {
                    swap(data, j, j+1);
                }
            }
        }
    }

    private static void swap(int[] data, int j, int i) {
        int tmp = data[j];
        data[j] = data[j+1];
        data[j+1] = tmp;
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
