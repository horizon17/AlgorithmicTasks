package ru.alexx.belov.algorithmic_tsk.bitManipulation;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/
 */
@QuarkusTest
class sortByFirstBite {

    @Test
    void process() {

        int[] input = new int[] {0,1,2,3,4,5,6,7,8}; // Output: [0,1,2,4,8,3,5,6,7]
        System.out.print(Arrays.toString(sortByBits(input)));

    }


    public int[] sortByBits(int[] arr) {
        Integer[] sorted = new Integer[arr.length];
        Arrays.setAll(sorted, i -> arr[i]);
        Arrays.sort(sorted, Comparator.comparingInt(Integer::bitCount).
                thenComparing(Comparator.naturalOrder()));
        Arrays.setAll(arr, i -> sorted[i]);
        return arr;
    }
}