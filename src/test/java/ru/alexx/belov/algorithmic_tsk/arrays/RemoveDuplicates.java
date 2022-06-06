package ru.alexx.belov.algorithmic_tsk.arrays;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 *
 *
 *
 */
@QuarkusTest
class RemoveDuplicates {

    @Test
    void process() {

        // 0,1,2,4,5,7      // 0,2,3,4,6,8,9
        int[] arr1 = new int [] {0,0,1,1,1,2,2,3,3,4}; // Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
        System.out.println((removeDuplicates(arr1)));

        arr1 = new int [] { 0,1,2,4,5,7};
        Assert.assertTrue(removeDuplicates(arr1) == 0);

    }

    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int j = 0;
        for (int i = 0; i < n-1; i++) {
            if (nums[i] != nums[i+1]) {
                nums[j++] = nums[i];
            }
        }
        nums[j++] = nums[n-1];

        return j;
    }

}