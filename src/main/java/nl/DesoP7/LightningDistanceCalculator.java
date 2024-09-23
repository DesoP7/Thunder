package nl.DesoP7;

import java.util.Scanner;

public class LightningDistanceCalculator {

    public static void main(String[] args) {
        // Create a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);

        // Speed of sound in meters per second
        final double SPEED_OF_SOUND = 343.0;

        // Ask the user for the preferred unit of measurement: feet or kilometers
        System.out.println("Would you like the distance in feet or kilometers? Type 'feet' or 'km':");
        String unit = scanner.nextLine();

        // Loop to repeatedly ask the user for input
        while (true) {
            // Ask for the number of seconds between lightning and thunder
            System.out.print("Enter the seconds between lightning and thunder (or type 'exit' to stop): ");
            String input = scanner.nextLine();

            // Exit the loop if the user types 'exit'
            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            try {
                // Convert the input to a double (number of seconds)
                double seconds = Double.parseDouble(input);

                // Calculate the distance to the lightning in meters
                double distanceInMeters = seconds * SPEED_OF_SOUND;

                // Convert the distance to the chosen unit (feet or kilometers)
                if (unit.equalsIgnoreCase("feet")) {
                    // 1 meter = 3.28084 feet
                    double distanceInFeet = distanceInMeters * 3.28084;
                    System.out.printf("The distance to the lightning is %.2f feet.\n", distanceInFeet);
                } else if (unit.equalsIgnoreCase("km")) {
                    // Convert meters to kilometers (1 km = 1000 meters)
                    double distanceInKilometers = distanceInMeters / 1000.0;
                    System.out.printf("The distance to the lightning is %.2f kilometers.\n", distanceInKilometers);
                } else {
                    System.out.println("Invalid unit. Please restart the program and choose 'feet' or 'km'.");
                    break;
                }

                // Print the speed of the lightning (fixed as sound travels at the speed of sound)
                System.out.printf("The sound of thunder travels at %.2f meters per second.\n", SPEED_OF_SOUND);

                // Display how long it will take for the lightning's sound to reach the user
                System.out.printf("It took %.2f seconds for the sound to reach you.\n", seconds);

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number of seconds or 'exit' to stop.");
            }
        }

        // Close the scanner object to free resources
        scanner.close();
    }
}
