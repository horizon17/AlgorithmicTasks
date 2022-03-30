package ru.alexx.belov.algorithmic_tsk.greedy;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/maximum-units-on-a-truck/
 *
 */
@QuarkusTest
class MaximumUnitsOnTruck {

    @Test
    void process() {

        int[][] boxes = new int[][] {{5,10},{2,5},{4,7},{3,9}};
        int truckSize = 10;
        System.out.println(maximumUnits(boxes, truckSize));

    }


    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);

        int units = 0;
        for (int i = 0; i < boxTypes.length; i++) {
            int curr = Math.min(boxTypes[i][0], truckSize);
            units += curr * boxTypes[i][1];
            truckSize -= curr;
            if (truckSize == 0) {
                break;
            }
        }
        return units;
    }

}