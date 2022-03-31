package ru.alexx.belov;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Working builder
 */
@Data
public class TestHelper {

    public List<ArrayTarget> intArrayTarget = new ArrayList<>();

    public List<StringSimple> stringSimple = new ArrayList<>();

    @Data
    public class ArrayTarget {
        int[] input;
        int target;
        int answer;
    }

    public TestHelper(ArrayTargetBuilder arrayTargetBuilder) {
        ArrayTarget at = new ArrayTarget();
        at.input = arrayTargetBuilder.input;
        at.target = arrayTargetBuilder.target;
        at.answer = arrayTargetBuilder.answer;
        intArrayTarget.add(at);
    }

    public void topAdd(addToArray add) {
        ArrayTarget at = new ArrayTarget();
        at.input = add.input;
        at.target = add.target;
        at.answer = add.answer;
        intArrayTarget.add(at);
    }

    public static class ArrayTargetBuilder {
        private int[] input;
        private int target;
        private int answer;

        public ArrayTargetBuilder input(int[] nums) {
            this.input = nums;
            return this;
        }

        public ArrayTargetBuilder target(int target) {
            this.target = target;
            return this;
        }

        public ArrayTargetBuilder answer(int answer) {
            this.answer = answer;
            return this;
        }

        public TestHelper build() {
            TestHelper helper = new TestHelper(this);
            return helper;
        }

    }

    public static class addToArray {
        private int[] input;
        private int target;
        private int answer;

        public addToArray input(int[] nums) {
            this.input = nums;
            return this;
        }

        public addToArray target(int target) {
            this.target = target;
            return this;
        }

        public addToArray answer(int answer) {
            this.answer = answer;
            return this;
        }

        public TestHelper add(TestHelper th) {
            th.topAdd(this);
            return th;
        }
    }


    @Data
    public class StringSimple {
        String input;
        boolean answer;
    }

}
