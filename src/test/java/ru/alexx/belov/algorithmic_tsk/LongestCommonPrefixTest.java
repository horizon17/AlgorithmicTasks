package ru.alexx.belov.algorithmic_tsk;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/longest-common-prefix/
 *
 */
@QuarkusTest
class LongestCommonPrefixTest {


    // todo - Horizontal scanning
    @Test
    void process() {

        //String[] strs = new String[] {"floight","flow","flower","flowgggg"};
        String[] strs = new String[] {"dog","racecar","car"};
        System.out.println(verticalScanning(strs));

    }

    /**
     * Runtime: 2 ms, faster than 31.27% of Java online submissions for Longest Common Prefix.
     * Memory Usage: 38.6 MB, less than 28.47% of Java online submissions for Longest Common Prefix.
     */
    public String verticalScanning(String[] strs) {
        String prefix = "";
        int prf = 0;
        int i = 0;
        String currChar = "";
        while (true) {
            if (prf+1 > strs[i].length()) {
                return prefix;
            }
            if (i == 0) {
                currChar = strs[i].substring(prf, prf+1);
            }
            if (!currChar.equals(strs[i].substring(prf, prf+1))) {
                return prefix;
            }
            i++;
            if (i ==  strs.length) {
                i = 0;
                prf++;
                prefix = prefix.concat(currChar);
            }
        }

    }

}