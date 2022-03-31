package ru.alexx.belov.lambda;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

@QuarkusTest
public class PassMethodAsParameter {

    class Component {
        String name;

        Component(String s) {
            this.name = s;
        }
    }

    // our Interface to pass method
    // OR we can use Consumer I - see HelperConsumer
    interface I {
        void myMethod(Component component);
    }

    class Helper {
        public void setAllComponents(Component[] myComponentArray, I myMethodsInterface) {
            for (Component leaf : myComponentArray) {
                myMethodsInterface.myMethod(leaf);
            }
        }
    }

    // here we gonna use Consumer functional interface with our Component type
    class HelperConsumer {
        public void setAllComponents(Component[] myComponentArray, Consumer<Component> myMethodsInterface) {
            for (Component leaf : myComponentArray) {
                myMethodsInterface.accept(leaf);
            }
        }
    }

    // helper with our interface
    @Test
    void test() {

        Helper helper = new Helper();

        Component[] components = new Component[]{new Component("k1"), new Component("k2")};

        helper.setAllComponents(components, r -> changeColor(r));
        helper.setAllComponents(components, r -> changeSize(r));

    }

    @Test
    void testConsumerI() {

        Component[] components = new Component[]{new Component("k1"), new Component("k2")};

        HelperConsumer helperConsumer = new HelperConsumer();
        helperConsumer.setAllComponents(components, r -> changeColor(r));
        helperConsumer.setAllComponents(components, r -> changeSize(r));

    }

    public void changeColor(Component component) {
        // code here
        System.out.println("this color changed for " + component.name);
    }

    public void changeSize(Component component) {
        // code here
        System.out.println("size was changed for " + component.name);
    }

}
