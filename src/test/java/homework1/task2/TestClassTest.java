package homework1.task2;

import org.junit.Before;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.*;

public class TestClassTest {
    private TestClass testClass;

    @Before
    public void createObject(){
        testClass = new TestClass();
    }

    @Test
    public void shouldCheckExceptionClass() throws Exception {
        Class<TestClass> clazz = TestClass.class;
        Method method = clazz.getMethod("getException");
        homework1.task2.annotation.Test test = method.getAnnotation(homework1.task2.annotation.Test.class);
        assertTrue(testClass.getException() == test.expected());
    }

}
