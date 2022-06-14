package ru.alexx.belov.algorithmic_tsk.arrays;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

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

        int[] arr1 = new int [] {0,0,1,1,1,2,2,3,3,4}; // Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
        Assert.assertTrue(removeDuplicates(arr1) == 5);

        arr1 = new int [] { 0,1,2,4,5,7};
        Assert.assertTrue(removeDuplicates(arr1) == 6);

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