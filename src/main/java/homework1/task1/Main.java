package homework1.task1;

import java.lang.reflect.Constructor;

public class Main {

    public MySingleton makeSingleton() {
        return MySingleton.getInstance();
    }

    public MySingleton makeByReflection() throws Exception {
        Class<MySingleton> clazz = MySingleton.class;
        Constructor<MySingleton> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        return constructor.newInstance();
    }

    public static void main(String[] args) {

    }

}
