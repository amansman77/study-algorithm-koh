package com.ho.study.algorithm.koh.sort;

public class Selection {
    
    public static void main(String[] args) {
        int[][] dataArr = {
            {1, 2, 3, 2, 1},
            {1, 2, 3, 5, 1},
            {29, 10, 14, 37, 13}
        };

        for (int[] data : dataArr) {
            Selection.sort(data);
    
            printArr(data);
        }
    }

    private static void sort(int[] data) {
        int cursor = data.length - 1;
        for (int i = 0; i < data.length - 1; i++, cursor--) {
            int k = findMax(data, 0, cursor);
            swap(data, k, cursor);
        }
    }

    private static int findMax(int[] data, int start, int end) {
        int max = data[start];
        int k = start;
        for (int j = start+1; j < end; j++) {
            if (max < data[j]) {
                k = j;
                max = data[k];
            }
        }
        return k;
    }

    private static void swap(int[] data, int k, int cursor) {
        int tmp = data[k];
        data[k] = data[cursor];
        data[cursor] = tmp;
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
