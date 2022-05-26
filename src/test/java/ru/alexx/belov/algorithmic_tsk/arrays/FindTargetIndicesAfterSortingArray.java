package ru.alexx.belov.algorithmic_tsk.arrays;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-target-indices-after-sorting-array/
 * similar to find the kth smallest element
 *
 */
@QuarkusTest
class FindTargetIndicesAfterSortingArray {

    @Test
    void process() {

        int[] arr = new int[] {1,2,5,2,3};
        int target = 5;
        System.out.println(MyMethod(arr, target));

    }

    /**
     * Посчитаем сколько элементов до target!
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Target Indices After Sorting Array.
     */
    public List<Integer> MyMethod(int[] nums, int target) {
        int tInd = 0;
        int tCount = 0;
        for (int i : nums) {
            if (i < target) tInd++;
            if (i == target) tCount++;
        }
        List<Integer> result = new ArrayList<>();
        for (int x = 0; x < tCount; x++) {
            result.add(tInd++);
        }
        return result;
    }



}