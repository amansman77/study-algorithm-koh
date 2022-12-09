package com.ho.study.algorithm.koh.recursion;

public class Factorial {

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }

        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(1 == Factorial.factorial(1));
        System.out.println(24 == Factorial.factorial(4));
    }
}