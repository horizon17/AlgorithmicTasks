package ru.alexx.belov.algorithmic_tsk.arrays;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/running-sum-of-1d-array/
 */
@QuarkusTest
class RunningSumOf1dArray {

    /**
     *
     */
    @Test
    void process() {

        int[] nums1 = new int [] {1,3,5,1};

        System.out.println(Arrays.toString(runningSum(nums1)));

    }

    public int[] runningSum(int[] nums) {

        int[] res = new int[nums.length];

        int prev = 0;
        for (int i = 0; i < nums.length; i++) {
            res[i] = prev + nums[i];
            prev = res[i];
        }
        return res;
    }




}