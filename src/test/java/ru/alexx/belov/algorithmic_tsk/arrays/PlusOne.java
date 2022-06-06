package ru.alexx.belov.algorithmic_tsk.arrays;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/plus-one/description/
 *
 * You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
 *
 * Increment the large integer by one and return the resulting array of digits.
 *
 */
@QuarkusTest
class PlusOne {

    @Test
    void process() {

        int[] arr1 = new int [] {0,1,2,4,5,7};
        System.out.println(Arrays.toString((plusOne(arr1))));

        arr1 = new int [] {0,2,3,4,6,8,9};
        System.out.println(Arrays.toString((plusOne(arr1))));

        arr1 = new int [] {1,1,2,1};
        System.out.println(Arrays.toString((plusOne(arr1))));

    }

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        digits = new int[digits.length + 1]; // да, весь массив всегда все 0, важна только его длина
        digits[0] = 1;
        return digits;
    }




}