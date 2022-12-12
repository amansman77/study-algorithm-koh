package com.ho.study.algorithm.koh.sort;

public class Counting {
    
    public static void main(String[] args) {
        int[][] dataArr = {
            {8, 11, 3, 73, 31, 48, 20, 29, 65, 15},
            {1, 2, 3, 2, 1},
            {1, 2, 3, 5, 1},
            {29, 10, 14, 37, 13}
        };

        for (int[] data : dataArr) {
            Counting.sort(data, 100);
    
            printArr(data);
        }
    }

    private static void sort(int[] data, int maxNumber) {
        int[] tmpArr = new int[data.length];
        int[] countArr = new int[maxNumber];
        for (int i = 0; i < data.length; i++) {
            countArr[data[i]]++;
        }

        for (int i = 1; i < countArr.length; i++) {
            countArr[i] = countArr[i-1] + countArr[i];
        }

        for (int i = data.length-1; i >= 0; i--) {
            tmpArr[(countArr[data[i]]--)-1] = data[i];
        }

        for (int i = 0; i < data.length; i++) {
            data[i] = tmpArr[i];
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
