package ru.alexx.belov.algorithmic_tsk.string;

import lombok.Data;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Working builder
 */
@Data
public class TestHelperString {

    List<TestEntity> testEntityList = new ArrayList<>();


    public void checker(List<TestEntity> testEntites, IMethod method) {
        for (TestEntity nextEntity : testEntites) {
            Assert.assertTrue(nextEntity.answer == method.myMethod(nextEntity));
        }
    }


}
