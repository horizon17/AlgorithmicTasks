package ru.alexx.belov.algorithmic_tsk.arrays;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/remove-element/
 *
 * !!! It does not matter what you leave beyond the first k elements !!!
 */
@QuarkusTest
class RemoveElement {

    @Test
    void process() {

        //Integer[] arr = new Integer[] {0,1,2,2,3,0,4,2};
        int remove = 2;

        int[] arr = new int[] {0,1,2,2,3,0,4,2};
        System.out.println(notMyMethod(arr, remove));

    }

    /**
     * best left shift !
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Element.
     */
    public int notMyMethod(int[] nums, int remove) {
        int i = 0;
        for (int n : nums) {
            if (n != remove) {
                nums[i++] = n;
            }
        }
        System.out.println(Arrays.toString(nums));
        return i;
    }

    /**
     * Пиздец, делай проще!
     */
    public int myMethod(Integer[] nums, int remove) {
        int k = 0;
        int reversCount = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == remove) {
                nums[i] = getReversElement(nums, reversCount, remove);
                nums[reversCount] = 999;
                reversCount--;
                k++;
            }
        }
        System.out.println(Arrays.asList(nums));
        return k;
    }

    private int getReversElement(Integer[] nums, int reversCount, int remove) {
        if (nums[reversCount] == remove) {
            nums[reversCount] = 999;
            reversCount--;
            return getReversElement(nums, reversCount, remove);
        }
        return nums[reversCount];
    }


}