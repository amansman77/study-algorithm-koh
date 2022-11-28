package com.ho.study.algorithm.koh;

public class Power {
 
    private static double power(double x, double n) {
        if (n == 0) {
            return 1;
        }

        return x * power(x, n - 1);
    }

    public static void main(String[] args) {
        System.out.println(9 == Power.power(3, 2));
        System.out.println(16 == Power.power(4, 2));
    }

}
