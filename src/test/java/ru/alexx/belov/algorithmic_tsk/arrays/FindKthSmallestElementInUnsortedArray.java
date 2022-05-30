package ru.alexx.belov.leetcode.arrays.sortAlgorithms;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 *  find the kth smallest element - my solution
 *
 *  https://afteracademy.com/blog/kth-smallest-element-in-an-array/
 *  https://www.youtube.com/watch?v=u2dWchmzJog
 *
 */
@QuarkusTest
class mySort {

    /**
     *
     */
    @Test
    void process() {

        int[] arr = {5, -8, 10, 37, 101, 2, 9};
        int K = 6;
        int answer = 37;
        Assert.assertTrue(answer == testSort(arr, K));
        Assert.assertTrue(answer == getKthSmallest(arr, K));

        arr = new int[]{10, 3, 6, 9, 2, 4, 15, 23};
        K = 4;
        answer = 6;
        Assert.assertTrue(answer == testSort(arr, K));
        Assert.assertTrue(answer == getKthSmallest(arr, K));


    }

    // my solution based on sorting by inserting element in same index in []
    public Integer testSort(int arr[], int K) {  // todo - funny: signature works
        List<Integer> res = new ArrayList<>(); // capacity of List != int[100]
        List<Integer> resNeg = new ArrayList<>();
        //Integer[] res = new Integer[200]; // cant increase capacity without copy of arr
        //Integer[] resNeg = new Integer[200];
        for (int i=0; i < arr.length; i++) {
            if (arr[i] < 0) {
                resNeg = increaseArray(resNeg, arr[i] * -1); // make sense for List, not []
                resNeg.add(arr[i] * -1, arr[i]);
                continue;
            }
            res = increaseArray(res, arr[i]);
            res.add(arr[i], arr[i]);
        }
        int iK = 1;
        // todo - reverse stream
        for (int n = resNeg.size() - 1; n > 0; n--) {
            if (resNeg.get(n) != null) {
                if (iK == K) {
                    return resNeg.get(n) ;
                }
                iK++;
            }
        }

        for (int i = 0; i < res.size(); i++) {
            if (res.get(i) != null) {
                if(iK == K) {
                    return res.get(i);
                }
                iK++;
            }
        }

        return null;
    }

    public List increaseArray(List list, int index) {
        if (list.size() <= index) {
            for (int i = list.size(); i < index; i++) { // arr[]; index=1 -->> arr[0]=null; arr[1]=1
                list.add(i, null);
            }
        }
        return list;
    }

    // lazy solution with PriorityQueue
    private static int getKthSmallest(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int n : nums) {
            //if(n != -1) {  here -1 was separator for waved array
                set.add(n);
            //}
        }
        Queue<Integer> minHeap = new PriorityQueue<>();  // queue wherein all the elements are ordered as per their natural ordering or based on a custom Comparator
        minHeap.addAll(set);
        while(minHeap.size() > 1 && k > 1) {
            minHeap.poll();
            k--;
        }
        return minHeap.peek();
    }


}