package homework1.task2;

import homework1.task2.annotation.After;
import homework1.task2.annotation.Before;
import homework1.task2.annotation.Ignore;
import homework1.task2.annotation.Test;

public class TestClass {

    @Before
    public void beforeMethod(){
        System.out.println("before method");
    }

    @After
    public void afterMethod(){
        System.out.println("after method");
    }

    @Test(expected = NullPointerException.class)
    public Class<? extends Exception> getException() {
        try {
            throw new NullPointerException();
        } catch (NullPointerException e) {
            System.out.println("Null pointer exception was thrown.");
            return e.getClass();
        }
    }

    @Ignore
    @Test
    public void getIgnored(){
        System.out.println("Ignored.");
    }

    @Test
    public void method1(){
        System.out.println("method1");
    }

    @Test
    public void method2(){
        System.out.println("method2");
    }

}
