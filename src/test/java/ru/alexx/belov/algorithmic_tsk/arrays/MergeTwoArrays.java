package ru.alexx.belov.algorithmic_tsk.arrays;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 *
 * Чисто merge двух массивов
 *
 */
@QuarkusTest
class MergeTwoArrays {

    /**
     *
     */
    @Test
    void process() {

        int[] arr1 = new int [] {1,3,5,8};
        int[] arr2 = new int [] {2,6,7};
        // 1 3 4 5 6 - ответ 4
        System.out.println(Arrays.toString(mySimpleMerge(arr1, arr2)));

    }

    /**
     * Good!
     * arr1 and arr2 sorted !!!
     * any size!
     */
    public int[] mySimpleMerge(int[] arr1, int[] arr2) {

        int n = arr1.length + arr2.length;
        int res[] = new int[n];
        int i = 0; // arr1 iterator
        int j = 0; // arr2 itearotr

        for (int k = 0; k < n; k++) {
            if (arr1[i] > arr2[j]) {
                res[k] = arr2[j];
                if (j < arr2.length - 1) {
                    j++;
                } else {
                    arr2[j] = Integer.MAX_VALUE;
                }
            } else {
                res[k] = arr1[i];
                if (i < arr1.length - 1) {
                    i++;
                } else {
                    arr1[i] = Integer.MAX_VALUE;
                }

            }
        }
        return res;
    }




}