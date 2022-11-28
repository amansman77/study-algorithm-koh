package com.ho.study.algorithm.koh;

public class Fibonacci {
 
    private static int fibonacci(int n) {
        if (n < 2) {
            return n;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(5 == Fibonacci.fibonacci(5));
        System.out.println(8 == Fibonacci.fibonacci(6));
    }

}
