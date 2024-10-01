package org.java.LeetCode.TwoSum;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        TwoSum lib = new TwoSum();

        System.out.println(Arrays.toString(lib.twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(lib.twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(lib.twoSum(new int[]{3, 3}, 6)));
        System.out.println(Arrays.toString(lib.twoSum(new int[]{0, 1, 3, 0}, 0)));

    }
}