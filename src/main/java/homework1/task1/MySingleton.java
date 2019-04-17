package homework1.task1;

public class MySingleton {
    private static MySingleton instance;

    private MySingleton() {
    }

    /*public static MySingleton getInstance() {
        if (instance == null) {
            instance = new MySingleton();
        }
        return instance;
    }*/

    public static MySingleton getInstance() {
        MySingleton localInstance = instance;
        if (localInstance == null) {
            synchronized (MySingleton.class) {
                localInstance = instance;
                if (localInstance == null) {
                    localInstance = new MySingleton();
                    instance = localInstance;
                }
            }
        }
        return localInstance;
    }
}
