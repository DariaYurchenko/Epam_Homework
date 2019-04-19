package homework1.task2;

import homework1.task2.annotation.Ignore;
import homework1.task2.annotation.Test;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestClassMethods {
    private List<Method> testMethods;

    public TestClassMethods() {
        this.testMethods = new ArrayList<>();
    }

    private Method[] getMethods() {
        TestClass testClass = new TestClass();
        Class<TestClass> clazz = TestClass.class;
        return clazz.getMethods();
    }

    private void getTestMethods() {
        testMethods = Arrays.stream(getMethods())
                .filter(method -> method.isAnnotationPresent(Test.class))
                .filter(method -> !method.isAnnotationPresent(Ignore.class))
                .collect(Collectors.toList());
    }

    private void runSingleMethod(Object instance, Method method) {
        Class<? extends Throwable> expectedException = method.getAnnotation(Test.class).expected();
        try {
            method.invoke(instance);
        } catch (Exception e) {
            if (expectedException.equals(e.getCause().getClass())) {
                System.out.println("It is correct exception.");
                System.out.println("It's an expected exception.".equals(e.getCause().getMessage()));
            }
        }
    }

    private void runTestMethods(Object instance) {
        getTestMethods();
        testMethods.forEach(method -> runSingleMethod(instance, method));
    }

    public static void main(String[] args) throws Exception {
        TestClass testClass = new TestClass();
        TestClassMethods testClassMethods = new TestClassMethods();
        testClassMethods.runTestMethods(testClass);

    }
}
