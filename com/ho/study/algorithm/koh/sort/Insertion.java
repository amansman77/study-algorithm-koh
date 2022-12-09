package com.ho.study.algorithm.koh.sort;

public class Insertion {
    
    public static void main(String[] args) {
        int[][] dataArr = {
            {1, 2, 3, 2, 1},
            {1, 2, 3, 5, 1},
            {29, 10, 14, 37, 13}
        };

        for (int[] data : dataArr) {
            Insertion.sort(data);
    
            printArr(data);
        }
    }

    private static void sort(int[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            int position = findPosition(data, i+1);
            int tmpData = data[i+1];
            shiftRight(data, position, i+1);
            data[position] = tmpData;
        }
    }

    private static void shiftRight(int[] data, int start, int end) {
        for (int i = end; i > start; i--) {
            data[i] = data[i-1];
        }
    }

    private static int findPosition(int[] data, int i) {
        for (int j = i - 1; j >= 0; j--) {
            if (data[j] < data[i]) {
                return j+1;
            }
        }
        return 0;
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
