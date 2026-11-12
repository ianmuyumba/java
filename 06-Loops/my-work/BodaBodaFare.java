/*
 * Problem 6: Boda Boda Ride Fare Calculator
 * Java beginner assignment | Scanner, if-else, while loop and arithmetic
 *
 * Quick Notes
 * - The base fare is KSh 50 for the first 2 km.
 * - For distances greater than 2 km, distance charge = (distance - 2) * 20.
 * - Night surcharge is 50% of the basic fare from hour 22 through hour 5.
 * - Rush-hour surcharge is 25% of the basic fare during hours 7-9 and 17-19.
 * - Rain adds a flat KSh 30. The program applies one time-based surcharge
 *   plus any rain charge.
 * - The while loop repeats rides until distance 0 is entered; dailyEarnings
 *   accumulates each completed ride's fare.
 * - Negative distances and invalid hours are rejected, though this beginner
 *   version asks for a new ride after displaying the error.
 */
import java.util.Scanner; // Allows keyboard input

public class BodaBodaFare {
    public static void main(String[] args) {

        // Create a Scanner object to read the user's answers.
        Scanner input = new Scanner(System.in);

        // Declare variables for distance and fare calculations.
        double distance;        // Distance travelled in kilometres
        double baseFare;         // Fixed fare for the first 2 km
        double distanceCharge;   // Charge for distance beyond 2 km
        double basicFare;        // Base fare plus distance charge
        double timeSurcharge;    // Extra charge for night or rush hour
        double rainCharge;       // Extra charge if it is raining
        double totalFare;        // Final fare for one ride

        // Accumulate the fares from all completed rides.
        // Start at zero because no rides have been completed yet.
        double dailyEarnings = 0;

        // Store the hour (0-23) and the user's rain answer.
        int hour;
        String raining;

        // STEP 1: Ask for the first ride's distance.
        // Entering 0 ends the program.
        System.out.print("Enter distance in km (0 to stop): ");
        distance = input.nextDouble();

        // STEP 2: Repeat while the distance is not zero.
        // The != operator means "not equal to".
        while (distance != 0) {

            // STEP 3: Reject negative distances.
            if (distance < 0) {
                System.out.println("Invalid distance. "
                        + "Enter a positive distance.");
            } else {

                // STEP 4: Ask for the hour using the 24-hour clock.
                // For example, 18 means 6 PM and 22 means 10 PM.
                System.out.print("Enter hour of day (0-23): ");
                hour = input.nextInt();

                // Make sure the hour is within the valid range.
                if (hour < 0 || hour > 23) {
                    System.out.println("Invalid hour.");
                } else {

                    // STEP 5: Ask whether it is raining.
                    System.out.print("Is it raining? (yes/no): ");
                    raining = input.next();

                    // STEP 6: Calculate the basic fare.
                    // The first 2 kilometres cost KSh 50.
                    baseFare = 50;

                    // Journeys up to 2 km have no extra distance charge.
                    if (distance <= 2) {
                        distanceCharge = 0;
                    } else {
                        // Subtract the first 2 km.
                        // Charge KSh 20 for each remaining kilometre.
                        // Example: 5 km -> (5 - 2) * 20 = KSh 60.
                        distanceCharge = (distance - 2) * 20;
                    }

                    // Add the base fare and the distance charge.
                    basicFare = baseFare + distanceCharge;

                    // STEP 7: Calculate the time-based surcharge.
                    // Night hours: 10 PM to 5:59 AM (hours 22, 23, 0-5).
                    if (hour >= 22 || hour < 6) {

                        // Night surcharge is 50% of the basic fare.
                        timeSurcharge = basicFare * 0.50;

                    }
                    // If it is not night, check the rush-hour periods.
                    // Morning: 7-9 AM; evening: 5-7 PM (hours 17-19).
                    else if ((hour >= 7 && hour <= 9)
                            || (hour >= 17 && hour <= 19)) {

                        // Rush-hour surcharge is 25% of the basic fare.
                        timeSurcharge = basicFare * 0.25;

                    } else {
                        // No time surcharge at other hours.
                        timeSurcharge = 0;
                    }

                    // STEP 8: Calculate the rain charge.
                    // equalsIgnoreCase accepts yes, YES, Yes, and similar forms.
                    if (raining.equalsIgnoreCase("yes")) {
                        rainCharge = 30; // Add a flat KSh 30.
                    } else {
                        rainCharge = 0;  // No rain charge.
                    }

                    // STEP 9: Calculate the final fare.
                    // Add basic fare, time surcharge, and rain charge.
                    totalFare = basicFare + timeSurcharge + rainCharge;

                    // STEP 10: Display each part of the fare breakdown.
                    System.out.println("\n--- Ride Fare Breakdown ---");
                    System.out.printf("Base fare: KSh %.2f%n", baseFare);
                    System.out.printf("Distance charge: KSh %.2f%n",
                            distanceCharge);
                    System.out.printf("Time surcharge: KSh %.2f%n",
                            timeSurcharge);
                    System.out.printf("Rain charge: KSh %.2f%n", rainCharge);
                    System.out.printf("Total fare: KSh %.2f%n", totalFare);

                    // STEP 11: Add this ride's fare to daily earnings.
                    // Example: KSh 100 + KSh 150 = KSh 250.
                    dailyEarnings = dailyEarnings + totalFare;
                }
            }

            // STEP 12: Ask for the next ride.
            // This statement repeats until the user enters distance 0.
            System.out.print("\nEnter distance in km (0 to stop): ");
            distance = input.nextDouble();
        }

        // STEP 13: The loop has ended. Display all earnings for the day.
        System.out.printf("%nTotal daily earnings: KSh %.2f%n",
                dailyEarnings);

        // Inform the user that the fare calculator has stopped.
        System.out.println("Fare calculator stopped.");

        // Close Scanner after all input is complete.
        input.close();
    }
}
