import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int companies = scanner.nextInt();

        scanner.nextLine();
        int[] yearlyIncomes = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] taxes = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int number = 0;
        double maxTax = 0;
        for (int i = 0; i < companies; i++) {
            final double pay = ((double) taxes[i] * yearlyIncomes[i]) / 100;
            if (pay > maxTax) {
                maxTax = pay;
                number = i;
            }
        }

        System.out.println(number + 1);
    }
}