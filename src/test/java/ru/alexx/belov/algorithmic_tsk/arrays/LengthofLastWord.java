package ru.alexx.belov.algorithmic_tsk.arrays;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/plus-one/description/
 *
 *
 */
@QuarkusTest
class LengthofLastWord {

    @Test
    void process() {

        String ss = "Hello world";
        System.out.println((lengthOfLastWord(ss)));

    }

    public int lengthOfLastWord(String s) {
        int cnt = 0;
        char[] ss = s.toCharArray();
        for(int i = ss.length-1;i>=0;i--) {
            if(ss[i] == ' ')
            {
                if(cnt>0)
                {
                    return cnt;
                }
                continue;
            }

            cnt+=1;
        }
        return cnt;
    }




}