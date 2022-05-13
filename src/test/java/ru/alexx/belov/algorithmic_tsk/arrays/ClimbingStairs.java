package ru.alexx.belov.algorithmic_tsk.arrays;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

/**
 * https://leetcode.com/problems/climbing-stairs/
 * 12.28.2022
 */
@QuarkusTest
class ClimbingStairs {

    /**
     * n = 4
     * <p>
     * var:
     * 1+1+1+1
     * 2+2
     * 2+1+1
     * 1+2+1
     * 1+1+2
     */
    @Test
    void process() {

        int n = 3;
        System.out.println(climbStairs(n));

    }

    public int climbStairs(int n) {
        return climb_Stairs(0, n);
    }

    public int climb_Stairs(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        return climb_Stairs(i + 1, n) + climb_Stairs(i + 2, n);
    }


}