package ru.alexx.belov.algorithmic_tsk.arrays;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/missing-number/
 *
 *
 */
@QuarkusTest
class MissingNumber {

    /**
     *
     */
    @Test
    void process() {
        // [0,1,2,3,4,5,6,7,8,9]
        // [9,6,4,2,3,5,7,0,1]  n = 9
        int[] arr1 = new int [] {9,6,4,2,3,5,7,0,1};
        System.out.println((NotmyMethod(arr1)));

    }

    /**
     * We all know that a^b^b =a, which means two xor operations with the same number will eliminate the number
     * and reveal the original number.
     */
    public int NotmyMethod(int[] nums) {

        int xor = 0, i = 0;
        for (i = 0; i < nums.length; i++) {
            xor = xor ^ i ^ nums[i];
        }

        return xor ^ i;
    }

    /**
     * Runtime: 376 ms, faster than 5.25% of Java online submissions for Missing Number.
     */
    public int myMethod(int[] nums) {
        int n = nums.length;
        int res = 0;
        for (int x = 0; x <= n; x++) {
            int i = 0;
            for (int m : nums) {
                if (m != x) {
                    i++;
                }
            }
            if (i == nums.length) {
                res = x;
                break;
            }
        }
        return res;
    }





}