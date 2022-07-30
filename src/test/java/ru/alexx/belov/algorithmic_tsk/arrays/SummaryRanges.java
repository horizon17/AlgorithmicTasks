package ru.alexx.belov.algorithmic_tsk.arrays;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/summary-ranges/
 *
 *Input: nums = [0,1,2,4,5,7]
 * Output: ["0->2","4->5","7"]
 * Explanation: The ranges are:
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 *
 *
 * Input: nums = [0,2,3,4,6,8,9]
 * Output: ["0","2->4","6","8->9"]
 * Explanation: The ranges are:
 * [0,0] --> "0"
 * [2,4] --> "2->4"
 * [6,6] --> "6"
 * [8,9] --> "8->9"
 */
@QuarkusTest
class SummaryRanges {

    /**
     *
     */
    @Test
    void process() {

        int[] arr1 = new int [] {0,1,2,4,5,7};
        System.out.println((myMethod(arr1)));

        arr1 = new int [] {0,2,3,4,6,8,9};
        System.out.println((myMethod(arr1)));

    }

    /**
     * вариант где строка1 + строка2
     * Runtime: 7 ms, faster than 43.45% of Java online submissions for Summary Ranges.
     *
     * этот вариант со StringBuilder
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Summary Ranges.
     */
    public List<String> myMethod(int[] nums) {

        List<String> res = new ArrayList<>();
        StringBuilder range = new StringBuilder();
        int first = 0;
        for (int i = 0; i < nums.length; i++) {

            if (range.length() == 0) {
                range.append(nums[i]); // первый элемент
                first = nums[i];
                continue;
            }

            if (i != 0) {
                if (nums[i - 1] != nums[i] - 1) { // когда тек элемент разрушил последовательность
                    if (nums[i - 1] != first) {
                        range.append("->");
                        range.append(nums[i - 1]); // последний элемент отличный от первого
                    }
                    res.add(range.toString());
                    range.setLength(0);
                    range.append(nums[i]);
                    first = nums[i];
                }
            }

            if (i == nums.length - 1 && nums[i] != first) {
                range.append("->");
                range.append(nums[i]);
            }
        }
        if (range.length() != 0) {
            res.add(range.toString());
        }
        return res;
    }




}