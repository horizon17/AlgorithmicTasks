package ru.alexx.belov.algorithmic_tsk.arrays;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/binary-search/
 */

@QuarkusTest
class BinarySearch {

    @Test
    void process() {

        // [-1,0,3,5,9,12]
        int[] ints = new int[] {3,6,18,4,9,12,55,98,11,90,101};
        Arrays.sort(ints);

        int find = 133;
        //System.out.println(binarySearch(ints, 0, ints.length, find));
        System.out.println(search(ints, find));

        find = 12;
        System.out.println(binarySearch(ints, 0, ints.length, find));

        find = 3;
        System.out.println(binarySearch(ints, 0, ints.length, find));

        find = 101;
        System.out.println(binarySearch(ints, 0, ints.length, find));

    }

    // 1 2 3
    // 1 2 3 4
    public int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length, target);
    }

    private int binarySearch(int[] ints, int start, int end, int find) {
        boolean result = false;
        if (start > end) {
            return -1;
        }
        int mid = (end + start)/2;
        if (mid >= ints.length) {
            return -1;
        }

        if (find == ints[mid]) {
            return mid;
        }
        if (find < ints[mid]) {
            return binarySearch(ints, start, mid - 1, find);
        } else {
            return binarySearch(ints, mid + 1, end, find);
        }
    }

}