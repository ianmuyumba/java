/** Worked examples based on Oracle Section 5 task contracts. */
public class DecisionRules {
    public static String colour(double wavelength) {
        if (!Double.isFinite(wavelength) || wavelength < 380 || wavelength >= 750) {
            return "Outside spectrum";
        }
        if (wavelength < 450) return "Violet";
        if (wavelength < 495) return "Blue";
        if (wavelength < 570) return "Green";
        if (wavelength < 590) return "Yellow";
        if (wavelength < 620) return "Orange";
        return "Red";
    }

    public static String nextLightIf(int current) {
        if (current == 1) return "Green";
        if (current == 2) return "Yellow";
        if (current == 3) return "Red";
        return "Invalid colour";
    }

    public static String nextLightSwitch(int current) {
        switch (current) {
            case 1: return "Green";
            case 2: return "Yellow";
            case 3: return "Red";
            default: return "Invalid colour";
        }
    }

    public static int fare(int age) {
        if (age < 0) throw new IllegalArgumentException("Age must be nonnegative");
        // Literal Oracle slide rule: age 11 belongs in the otherwise branch.
        return age > 11 && age < 65 ? 5 : 3;
    }

    public static boolean shouldWatch(double price, int rating) {
        return price >= 12 && rating == 5;
    }

    public static void main(String[] args) {
        System.out.println("450.0 nm: " + colour(450));
        System.out.println("750.0 nm: " + colour(750));
        System.out.println("Light 1: " + nextLightSwitch(1));
        System.out.println("Fare at 11: " + fare(11));
        System.out.println("Movie at 12 with rating 5: " + shouldWatch(12, 5));
    }
}
