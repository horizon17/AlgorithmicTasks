package ru.alexx.belov.algorithmic_tsk.stack;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/palindrome-linked-list/
 *
 * Palindrome Linked List
 */
@QuarkusTest
class PalindromeLinkedList {


    @Test
    void process() {

        //ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(3))));

        System.out.println(isPalindrome(listNode));

    }

    /**
     * Ого! Моя первая идея = официальному решению!
     *
     * моя первая идея - выгрузить в массив и идти по массиву сравнивая 0+ и l- элементы, пока не достигнет середины.
     */
    public boolean isPalindrome(ListNode head) {
        List<Integer> numbs = new ArrayList<>();

        ListNode current = head;
        while (true) {
            numbs.add(current.val);
            if (current.next == null) {
                break;
            }
            current = current.next;
        }
        if (numbs.size() == 1) {
            return true;
        }
//        if (numbs.size() % 2 != 0 ) {
//            return false;
//        }

        int back = numbs.size() - 1;
        for (int i = 0; i < numbs.size(); i++) {
            if (numbs.get(i) != numbs.get(back--)) {
                return false;
            }
            if (i >= back) {
                break;
            }
        }

        return true;

    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


}