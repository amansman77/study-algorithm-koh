package com.ho.study.algorithm.koh.sort;

public class Quick {
    
    public static void main(String[] args) {
        int[][] dataArr = {
            {8, 11, 3, 73, 31, 48, 20, 29, 65, 15},
            {1, 2, 3, 2, 1},
            {1, 2, 3, 5, 1},
            {29, 10, 14, 37, 13}
        };

        for (int[] data : dataArr) {
            Quick.sort(data, 0, data.length-1);
    
            printArr(data);
        }
    }

    private static void sort(int[] data, int begin, int end) {
        if (begin >= end) {
            return;
        }

        Integer q = partition(data, begin, end);

        sort(data, begin, q);
        sort(data, q+2, end);
    }

    private static Integer partition(int[] data, int begin, int end) {
        Integer lowCursor = begin-1;
        for (int i = begin; i < end; i++) {
            if (data[i] < data[end]) {
                lowCursor++;
                swap(data, i, lowCursor);
            }
        }
        swap(data, lowCursor+1, end);

        return lowCursor;
    }

    private static void swap(int[] data, int first, int second) {
        Integer tmp = data[first];
        data[first] = data[second];
        data[second] = tmp;
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