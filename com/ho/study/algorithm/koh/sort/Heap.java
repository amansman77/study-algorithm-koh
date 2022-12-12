package com.ho.study.algorithm.koh.sort;

public class Heap {
    
    public static void main(String[] args) {
        int[][] dataArr = {
            {8, 11, 3, 73, 31, 48, 20, 29, 65, 15},
            {1, 2, 3, 2, 1},
            {1, 2, 3, 5, 1},
            {29, 10, 14, 37, 13}
        };

        for (int[] data : dataArr) {
            Heap.sort(data, 0, data.length-1);
    
            printArr(data);
        }
    }

    private static void sort(int[] data, int begin, int end) {
        if (begin >= end) {
            return;
        }
        makeHeap(data, begin, end);
        swap(data, begin, end);

        sort(data, begin, end-1);
    }

    private static void makeHeap(int[] data, int begin, int end) {
        for (int i = end-1; i >= begin; i--) {
            heapify(data, i, end);
        }
    }

    private static void heapify(int[] data, int rootCursor, int end) {
        if (rootCursor > end) {
            return;
        } else if (end < 2) {
            if (data[rootCursor] < data[end]) {
                swap(data, rootCursor, end);
            }
            return;
        }

        int lChildPosition = (rootCursor*2) + 1;
        int rChildPosition = (rootCursor*2) + 2;

        int lChildIndex = (rootCursor*2);
        int rChildIndex = (rootCursor*2) + 1;
        if (rootCursor == 0) {
            lChildIndex = 1;
            rChildIndex = 2;
        }

        if (rChildPosition <= end) {
            if (data[lChildIndex] > data[rChildIndex]) {
                if (data[rootCursor] < data[lChildIndex]) {
                    swap(data, rootCursor, lChildIndex);
                    heapify(data, lChildIndex, end);
                }
            } else {
                if (data[rootCursor] < data[rChildIndex]) {
                    swap(data, rootCursor, rChildIndex);
                    heapify(data, rChildIndex, end);
                }
            }
        } else if (lChildPosition <= end) {
            if (data[rootCursor] < data[lChildIndex]) {
                swap(data, rootCursor, lChildIndex);
                heapify(data, lChildIndex, end);
            }
        }
    }

    private static void swap(int[] data, int first, int second) {
        int tmp = data[first];
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
