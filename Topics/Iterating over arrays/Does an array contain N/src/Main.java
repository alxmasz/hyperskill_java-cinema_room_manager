import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();
        scanner.nextLine();
        int[] arr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int value = scanner.nextInt();

        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (arr[i] == value) {
                found = true;
                break;
            }
        }

        System.out.println(found);
    }
}