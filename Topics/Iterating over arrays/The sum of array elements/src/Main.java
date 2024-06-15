import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();
        scanner.nextLine();
        String elements = scanner.nextLine();

        String[] array = elements.split(" ");

        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += Integer.parseInt(array[i]);
        }

        System.out.println(sum);
    }
}