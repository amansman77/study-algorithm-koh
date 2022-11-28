package com.ho.study.algorithm.koh;

public class Gcd {
 
    private static double euclid(int m, int n) {
        if (m < n) {
            int tmp = m; 
            m = n;
            n = tmp;
        }

        if (m % n == 0) {
            return n;
        }

        return euclid(n, m % n);
    }

    private static double euclid_simple(int p, int q) {
        if (q == 0) {
            return p;
        }

        return euclid_simple(q, p % q);
    }

    public static void main(String[] args) {
        System.out.println(6 == Gcd.euclid(12, 18));
        System.out.println(6 == Gcd.euclid_simple(12, 18));

        System.out.println(12 == Gcd.euclid(60, 48));
        System.out.println(12 == Gcd.euclid_simple(60, 48));
    }

}
