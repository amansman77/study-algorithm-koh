package com.ho.study.algorithm.koh.recursion;

import java.util.ArrayList;
import java.util.List;

public class Powerset {
    
    private static final char[] DATA = {'a', 'b', 'c', 'd', 'e', 'f'};
    private static final int N = DATA.length;
    private static final boolean[] include = new boolean[N];

    public static void main(String[] args) {
        List<String> subset = new ArrayList<>();
        Powerset.powerset(subset, 0);

        System.out.println(64 == subset.size());
        printArray(subset);
    }

    private static void printArray(List<String> subset) {
        for (int i = 0; i < subset.size(); i++) {
            if (i > 1) {
                System.out.print(", ");
            }
            System.out.print(subset.get(i));
        }
        System.out.println("");
    }

    private static void powerset(List<String> subset, int position) {
        if (position == N) {
            String str = "";
            for (int i = 0; i < N; i++) {
                if (include[i]) {
                    str += DATA[i];
                }
            }
            subset.add(str);
            return ;
        }

        include[position] = false;
        powerset(subset, position + 1);
        include[position] = true;
        powerset(subset, position + 1);
    }
}
