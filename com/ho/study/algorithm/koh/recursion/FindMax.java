package com.ho.study.algorithm.koh.recursion;

public class FindMax {
    
    public static void main(String[] args) {
        int[] maxArr = {1,2,3,4,5,4,3,2,1};
        int max = FindMax.max(maxArr[0], maxArr, 1);
        System.out.println(5 == max);

        int max1 = findMax(maxArr, 0, maxArr.length - 1);
        System.out.println(5 == max1);

        int max2 = findMax02(maxArr, 0, maxArr.length - 1);
        System.out.println(5 == max2);
    }

    private static int max(int maxValue, int[] maxArr, int index) {
        if (index == maxArr.length) {
            return maxValue;
        } else {
            return max(Math.max(maxValue, maxArr[index]), maxArr, index+1);
        }
    }

    private static int findMax(int[] data, int begin, int end) {
        if (begin == end) {
            return data[begin];
        } else {
            return Math.max(data[begin], findMax(data, begin + 1, end));
        }
    }

    private static int findMax02(int[] data, int begin, int end) {
        if (begin == end) {
            return data[begin];
        } else {
            int middle = (begin + end) / 2;
            int max1 = findMax02(data, begin, middle);
            int max2 = findMax02(data, middle + 1, end);
            return Math.max(max1, max2);
        }
    }
}
