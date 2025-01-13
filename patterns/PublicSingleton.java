class Singleton {
    // Private static variable of the single instance
    private static Singleton instance;

    // Private constructor to prevent instantiation from outside
    private Singleton() {
        System.out.println("Singleton instance created.");
    }

    // Public static method to provide global access point to the instance
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    // Example method to demonstrate functionality
    public void showMessage() {
        System.out.println("Singleton instance works.");
    }
}


public class PublicSingleton {
    public static void main(String[] args) {
        // Attempt to create multiple instances
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();

        // Verify that both references point to the same instance
        System.out.println("Are instance1 and instance2 the same? " + (instance1 == instance2));

        // Call a method on the Singleton instance
        instance1.showMessage();
    }
}
