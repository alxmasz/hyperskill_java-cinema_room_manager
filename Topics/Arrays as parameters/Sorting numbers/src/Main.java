import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void sort(int[] numbers) {
        for (int i = 0; i < numbers.length / 2; i++) {
            for (int j = i; j < numbers.length - 1 - i; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int aux = numbers[j + 1];
                    numbers[j + 1] = numbers[j];
                    numbers[j] = aux;
                }
            }

            for (int j = numbers.length - 1 - i; j >= i + 1; j--) {
                if (numbers[j - 1] > numbers[j]) {
                    int aux = numbers[j - 1];
                    numbers[j - 1] = numbers[j];
                    numbers[j] = aux;
                }
            }
        }
    }

    /* Do not change code below */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        String[] values = scanner.nextLine().split("\\s+");
        int[] numbers = Arrays.stream(values)
                .mapToInt(Integer::parseInt)
                .toArray();

        sort(numbers);
        Arrays.stream(numbers).forEach(e -> System.out.print(e + " "));
    }
}