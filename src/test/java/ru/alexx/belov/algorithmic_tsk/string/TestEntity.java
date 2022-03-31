package ru.alexx.belov.algorithmic_tsk.string;

import lombok.Data;

/**
 * Working builder
 */
@Data
public class TestEntity {

    String string1;
    String string2;
    boolean answer;

    public TestEntity(String s1, String s2, boolean a) {
        this.string1 = s1;
        this.string2 = s2;
        this.answer = a;
    }





}
