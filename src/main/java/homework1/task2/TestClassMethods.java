package homework1.task2;

import homework1.task2.annotation.After;
import homework1.task2.annotation.Before;
import homework1.task2.annotation.Ignore;
import homework1.task2.annotation.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class TestClassMethods {
    private ArrayList<Method> ignoreMethods;
    private ArrayList<Method> testMethods;
    private ArrayList<Method> beforeMethods;
    private ArrayList<Method> afterMethods;


    public TestClassMethods() {
        this.ignoreMethods = new ArrayList<>();
        this.testMethods = new ArrayList<>();
        this.beforeMethods = new ArrayList<>();
        this.afterMethods = new ArrayList<>();
    }

    private Method[] getMethods() {
        TestClass testClass = new TestClass();
        Class<TestClass> clazz = TestClass.class;
        return clazz.getMethods();
    }

    private void getTestMethods() {
        for(int i = 0; i < getMethods().length; i++) {
            if(!getMethods()[i].isAnnotationPresent(Ignore.class) && getMethods()[i].isAnnotationPresent(Test.class)) {
                testMethods.add(getMethods()[i]);
            }
        }
    }

    private void getIgnoredMethods() {
        for(int i = 0; i < getMethods().length; i++) {
            if(getMethods()[i].isAnnotationPresent(Ignore.class)) {
                ignoreMethods.add(getMethods()[i]);
            }
        }
    }

    private void getBeforeMethods() {
        for(int i = 0; i < getMethods().length; i++) {
            if(getMethods()[i].isAnnotationPresent(Before.class)) {
                beforeMethods.add(getMethods()[i]);
            }
        }
    }

    private void getAfterMethods() {
        for(int i = 0; i < getMethods().length; i++) {
            if(getMethods()[i].isAnnotationPresent(After.class)) {
                afterMethods.add(getMethods()[i]);
            }
        }
    }

    private void getAllMethods(){
        getTestMethods();
        getBeforeMethods();
        getAfterMethods();
        getIgnoredMethods();
    }

    private void runSingleMethod(Object instance, Method method) {
        try {
            method.invoke(instance);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void runIgnoreMethods(TestClass testClass) {
        for (Method ignoreMethod : ignoreMethods) {
            runSingleMethod(testClass, ignoreMethod);
        }
    }

    private void runTestMethods(TestClass testClass) {
        for (Method testMethod : testMethods) {
            runSingleMethod(testClass, testMethod);
        }
    }

    private void runBeforeMethods(TestClass testClass) {
        for (Method beforeMethod : beforeMethods) {
            runSingleMethod(testClass, beforeMethod);
        }
    }

    private void runAfterMethods(TestClass testClass) {
        for (Method afterMethod : afterMethods) {
            runSingleMethod(testClass, afterMethod);
        }
    }

    private void runAllMethods(TestClass testClass) {
        for (Method testMethod : testMethods) {
            runBeforeMethods(testClass);
            runSingleMethod(testClass, testMethod);
            runAfterMethods(testClass);
        }
    }

    public static void main(String[] args) throws Exception {
        TestClass testClass = new TestClass();
        TestClassMethods testClassMethods = new TestClassMethods();
        testClassMethods.getAllMethods();
        testClassMethods.runAllMethods(testClass);
    }

}
