import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        scanner.nextLine();
        int[] elements = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        boolean isSortedAscending = true;

        for (int i = 0; i < size - 1; i++) {
            if (elements[i] > elements[i + 1]) {
                isSortedAscending = false;
                break;
            }
        }

        System.out.println(isSortedAscending);
    }
}