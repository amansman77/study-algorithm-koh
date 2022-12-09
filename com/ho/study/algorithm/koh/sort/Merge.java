package com.ho.study.algorithm.koh.sort;

public class Merge {
    
    public static void main(String[] args) {
        int[][] dataArr = {
            {1, 2, 3, 2, 1},
            {1, 2, 3, 5, 1},
            {29, 10, 14, 37, 13}
        };

        for (int[] data : dataArr) {
            Merge.sort(data, 0, data.length-1);
    
            printArr(data);
        }
    }

    private static void sort(int[] data, int start, int end) {
        if (start == end) {
            return;
        }

        int k = (start + end) / 2;
        sort(data, start, k);
        sort(data, k+1, end);
        merge(data, start, k, end);
    }

    private static void merge(int[] data, int start, int k, int end) {
        int[] tmpData = new int[data.length];
        int firstPosition = start;
        int secondPosition = k + 1;
        int tmpPosition = start;

        while (firstPosition <= k && secondPosition <= end) {
            if (data[firstPosition] <= data[secondPosition]) {
                tmpData[tmpPosition++] = data[firstPosition++];
            } else {
                tmpData[tmpPosition++] = data[secondPosition++];
            }
        }

        while (firstPosition <= k) {
            tmpData[tmpPosition++] = data[firstPosition++];
        }
        while (secondPosition <= end) {
            tmpData[tmpPosition++] = data[secondPosition++];
        }

        for (int i = start; i <= end; i++) {
            data[i] = tmpData[i];
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
