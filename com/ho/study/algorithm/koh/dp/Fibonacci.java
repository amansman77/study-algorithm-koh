package com.ho.study.algorithm.koh.dp;

public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(5 == Fibonacci.fibonacci(5));
        System.out.println(8 == Fibonacci.fibonacci(6));
    }

    private static int fibonacci(int n) {
        int[] f = new int[n+1];

        f[1] = 1;
        f[2] = 1;
        for (int i = 3; i <= n; i++) {
            f[i] = f[i-1] + f[i-2];
        }
        return f[n];
    }

}