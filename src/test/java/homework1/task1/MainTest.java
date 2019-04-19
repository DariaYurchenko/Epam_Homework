package homework1.task1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {
    Main main;

    @Before
    public void createMain(){
        main = new Main();
    }

    @Test
    public void shouldCreateNewSingleton() throws Exception {
        boolean compareSingletones = (main.makeSingleton() == main.makeByReflection());
        assertFalse(compareSingletones);
    }

    @Test
    public void shouldNotCreateNewSingleton() throws Exception {
        boolean compareSingletones = (main.makeSingleton() == (main.makeSingleton()));
        assertTrue(compareSingletones);
    }

}
