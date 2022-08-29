package ru.alexx.belov.algorithmic_tsk.string;

import lombok.Data;

/**
 * one value input
 */
@Data
public class TestEntity1W extends AbstractTestEntity{

    String string1;
    boolean answer;

    public TestEntity1W(String s1, boolean a) {
        this.string1 = s1;
        this.answer = a;
    }





}
