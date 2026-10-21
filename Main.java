
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ArrayList<Delivery> deliveries = new ArrayList<>();

        int numberOfDeliveries;

        // Read number of deliveries
        do {
            System.out.print("Enter number of deliveries (1-100): ");
            numberOfDeliveries = input.nextInt();
        } while (numberOfDeliveries < 1 || numberOfDeliveries > 100);

        // Read delivery information
        for (int i = 1; i <= numberOfDeliveries; i++) {

            System.out.println("\nDelivery " + i);

            String type;

            do {
                System.out.print("Enter delivery type (R/E): ");
                type = input.next().toUpperCase();
            } while (!type.equals("R") && !type.equals("E"));

            int distance;

            do {
                System.out.print("Enter distance (1-1000 km): ");
                distance = input.nextInt();
            } while (distance < 1 || distance > 1000);

            int weight;

            do {
                System.out.print("Enter weight (1-1000 kg): ");
                weight = input.nextInt();
            } while (weight < 1 || weight > 1000);

            // Create delivery object
            if (type.equals("R")) {
                deliveries.add(new RegularDelivery(distance, weight));
            } else {
                deliveries.add(new ExpressDelivery(distance, weight));
            }
        }

        // Calculate and display fees
        long totalFee = 0;


        for (int i = 0; i < deliveries.size(); i++) {

            long fee = deliveries.get(i).calculateFee();

            System.out.println(
                    "Delivery " + (i + 1) + " Fee: " + fee
            );

            totalFee += fee;
        }

        System.out.println("Total Fee: " + totalFee);

        input.close();
    }
}
