import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();

        int[][] array = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                array[i][j] = scanner.nextInt();
            }
        }

        boolean isSymmetric = true;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (array[i][j] != array[j][i]) {
                    isSymmetric = false;
                    break;
                }
            }
        }

        System.out.println(isSymmetric ? "YES" : "NO");
    }
}