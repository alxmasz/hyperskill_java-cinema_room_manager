import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int COST_PER_KILOMETER = 10;

        // Initialize a Scanner to read the user's input
        Scanner scanner = new Scanner(System.in);

        // Read the number of kilometers from the user's input
        int kilometers = scanner.nextInt();

        // Apply the cost calculation formula here
        int totalCost = kilometers * COST_PER_KILOMETER;

        // Print the total cost of the trip
        System.out.println(totalCost);
    }
}