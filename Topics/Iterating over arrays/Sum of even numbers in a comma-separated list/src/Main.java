import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a string that contains numbers separated by commas
        String numString = scanner.nextLine(); // Put your numbers here

        // Split the string into an array of string numbers
        String[] stringArr = numString.split(",");

        // Convert the array of string numbers into array of integers
        int[] numArr = new int[stringArr.length];
        for (int i = 0; i < stringArr.length; i++) {
            numArr[i] = Integer.parseInt(stringArr[i]);
        }

        // Create a variable to store the sum of all even numbers
        int evenSum = 0;

        // Insert code here to iterate over the integer array and calculate the sum of all even numbers
        for (int i = 0; i < numArr.length; i++) {
            if (numArr[i] % 2 == 0) {
                evenSum += numArr[i];
            }
        }

        // Print the sum of all even numbers
        System.out.println(evenSum);
    }
}