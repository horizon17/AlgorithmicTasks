package ru.alexx.belov.algorithmic_tsk.string;

import lombok.Data;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Helper with several functional interfaces
 */
@Data
public class TestHelperString {

    List<AbstractTestEntity> testEntityList = new ArrayList<>();

    // Function Int for 2 parameters and return
    public void checker(List<AbstractTestEntity> testEntities, BiFunction method) {
        for (AbstractTestEntity next : testEntities) {
            TestEntity nextTEnt = (TestEntity) next;
            Assert.assertTrue(method.apply(nextTEnt.string1, nextTEnt.string2).equals(nextTEnt.answer));
        }
    }

    public void checker(List<AbstractTestEntity> testEntities, IMethod method) {
        for (AbstractTestEntity abstractEntity : testEntities) {
            TestEntity next = (TestEntity) abstractEntity;
            Assert.assertTrue(next.answer == method.myMethod(next));
        }
    }

    // Function Int for 1 parameter and return
    public void checker(List<AbstractTestEntity> testEntities, Function method) {
        for (AbstractTestEntity abstractEntity : testEntities) {
            TestEntity1W next = (TestEntity1W) abstractEntity;
            System.out.println(next.string1 + " is should be " + next.answer);
            Assert.assertTrue(method.apply(next.string1).equals(next.answer));
        }
    }


}
