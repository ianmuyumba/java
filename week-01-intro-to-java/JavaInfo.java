// Task 4: read information about the Java runtime this program is running on.
public class JavaInfo {
    public static void main(String[] args) {
        System.out.println("Java Version: " + System.getProperty("java.version"));
        System.out.println("Java Home: " + System.getProperty("java.home"));
        System.out.println("Operating System: " + System.getProperty("os.name"));
    }
}
