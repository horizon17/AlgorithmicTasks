package ru.alexx.belov.algorithmic_tsk.string;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-anagram/
 */
@QuarkusTest
class ValidAnagram {

    @Test
    void process() {

        String s = "anagram"; String t = "nagaram";
        s = "ac"; t = "bb";

        System.out.println(isAnagram(s, t));

    }


    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);

        return Arrays.equals(ch1, ch2);
    }

}