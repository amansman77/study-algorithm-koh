package com.ho.study.algorithm.koh.recursion;

public class Permutation {
    
    private static final char[] DATA = {'a', 'b', 'c', 'd'};
    private static final int SIZE = DATA.length;

    public static void main(String[] args) {
        Permutation.perm(0);
    }

    private static void perm(int k) {
        if (k == SIZE) {
            for (int i = 0; i < SIZE; i++) {
                if (i > 0) {
                    System.out.print(", ");
                }
                System.out.print(DATA[i]);
            }
            System.out.println();
        }

        for (int i = k; i < SIZE; i++) {
            swapData(k, i);
            perm(k + 1);
            swapData(k, i);
        }
    }

    private static void swapData(int k, int i) {
        char tmp = DATA[k];
        DATA[k] = DATA[i];
        DATA[i] = tmp;
    }
}
