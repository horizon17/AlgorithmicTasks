package ru.alexx.belov.algorithmic_tsk.string;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/valid-anagram/
 */
@QuarkusTest
class ValidAnagram {

    @Test
    void process() {

        TestHelperString helperString = new TestHelperString();
        helperString.getTestEntityList().add(new TestEntity("anagram", "nagaram", true));
        helperString.getTestEntityList().add(new TestEntity("ac", "bb", false));

        helperString.checker(helperString.testEntityList, r -> isAr(r));

    }

    public boolean isAr(TestEntity r) {
        return isAnagram(r.string1, r.string2);
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