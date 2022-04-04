package ru.alexx.belov.algorithmic_tsk.string;

import lombok.Data;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;

/**
 * Helper with several functional interfaces
 */
@Data
public class TestHelperString {

    List<TestEntity> testEntityList = new ArrayList<>();

    public void checker(List<TestEntity> testEntities, BiFunction method) {
        for (TestEntity nextEntity : testEntities) {
            Assert.assertTrue(method.apply(nextEntity.string1, nextEntity.string2).equals(nextEntity.answer));
        }
    }

    public void checker(List<TestEntity> testEntities, IMethod method) {
        for (TestEntity nextEntity : testEntities) {
            Assert.assertTrue(nextEntity.answer == method.myMethod(nextEntity));
        }
    }

//    public void checker(List<TestEntity1W> testEntities, IMethod method) {
//        for (TestEntity1W nextEntity : testEntities) {
//            Assert.assertTrue(nextEntity.answer == method.myMethod(nextEntity));
//        }
//    }


}
