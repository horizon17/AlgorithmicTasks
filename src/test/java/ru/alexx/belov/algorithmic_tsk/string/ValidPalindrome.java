package ru.alexx.belov.algorithmic_tsk.string;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

/**
 * https://leetcode.com/problems/valid-palindrome/
 */
@QuarkusTest
class ValidPalindrome {

    @Test
    void process() {

        TestHelperString ths = new TestHelperString();
        ths.getTestEntityList().add(new TestEntity1W("A man, a plan, a canal: Panama", true));
        ths.getTestEntityList().add(new TestEntity1W("race a car", false));
        ths.getTestEntityList().add(new TestEntity1W(" ", true));
        ths.getTestEntityList().add(new TestEntity1W("A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.", false));
        ths.checker(ths.getTestEntityList(), r -> myMethod((String) r));

    }

    /**
     *
     */
    public boolean myMethod(String input) {
        input = input.replaceAll("[^a-zA-Z0-9]", "");
        input = input.toLowerCase();

        return isPalindrome(input);
    }

    /**
     * Идея: не переворачивать строку, читать одновременно слева и справа,
     * сравнивая зеркально символы, до середины:
     * <p>
     * Runtime: 26 ms, faster than 20.78% of Java online submissions for Valid Palindrome.
     * Memory Usage: 39.8 MB, less than 48.01% of Java online submissions for Valid Palindrome.
     */
    private boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    /**
     * ! Медленно
     * Runtime: 180 ms, faster than 5.69% of Java online submissions for Valid Palindrome.
     * Memory Usage: 44.2 MB, less than 6.97% of Java online submissions for Valid Palindrome.
     */
    private String simpleReverse(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb = sb.insert(0, str.charAt(i));
        }
        return sb.toString();
    }
    /**
     *  Чужие решения:
     *  https://leetcode.com/problems/valid-palindrome/discuss/40291/Java-9ms-solution-with-some-of-my-thoughts
     */

    /**
     * recursive reverse
     * WARNING! вообще Out of memory on LeetCode !!!
     */
    private String reverse(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        return str.charAt(str.length() - 1) + reverse(str.substring(0, str.length() - 1));
    }
}