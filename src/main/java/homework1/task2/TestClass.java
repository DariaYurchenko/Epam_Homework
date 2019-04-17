package homework1.task2;

import homework1.task2.annotation.Ignore;
import homework1.task2.annotation.Test;

public class TestClass {

    @Ignore("this test must be ignored")
    @Test
    public void shouldBeIgnored(){
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

    @Test(expected = NullPointerException.class)
    public void shouldThrowException() {
        System.out.println("Null pointer exception was thrown.");
        throw new NullPointerException();
    }

}
