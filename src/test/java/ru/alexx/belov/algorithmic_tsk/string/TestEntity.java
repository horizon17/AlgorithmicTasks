package ru.alexx.belov.algorithmic_tsk.string;

import lombok.Data;

/**
 * two value input
 */
@Data
public class TestEntity extends AbstractTestEntity{

    String string1;
    String string2;
    boolean answer;

    public TestEntity(String s1, String s2, boolean a) {
        this.string1 = s1;
        this.string2 = s2;
        this.answer = a;
    }





}
