package ru.alexx.belov.algorithmic_tsk.arrays;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

/**
 * https://leetcode.com/problems/container-with-most-water/
 *
 * Тоже обсудили с Мишей
 */
@QuarkusTest
class ContainerWithMostWather {

    /**
     *
     */
    @Test
    void process() {

        //int[] arr = new int [] {1,8,6,2,5,4,8,3,7}; // 49 - тк от 8 до 7 кол шагов - 7 и
        int[] arr = new int [] {4,3,2,1,4};
        //int[] arr = new int [] {1, 2, 1};

        System.out.println(method(arr));

    }

    /**
     *  Те наиболее удаленные друг от друга элементы макс высоты дают максимум при mix(элм1, элм2).
     *
     *  4,3,2,1,4 внешний проход
     *  4,3,2,1,4 внутрен проход
     *  |       |
     *  | |     |
     *  | | |   |
     *  | | | | |
     *
     * Runtime: 3 ms, faster than 82.42% of Java online submissions for Container With Most Water.
     * Memory Usage: 52.7 MB, less than 64.82% of Java online submissions for Container With Most Water.
     */
    public int method(int[] arr) {
        int maxV = 0;
        int i = 0;
        int k = arr.length - 1;
        while (i < k) {
            maxV = Math.max(maxV, (k - i) * Math.min(arr[i], arr[k]));
            if (arr[i] < arr[k]) {
                i++;
            } else {
                k--;
            }
        }
        return maxV;
    }



}