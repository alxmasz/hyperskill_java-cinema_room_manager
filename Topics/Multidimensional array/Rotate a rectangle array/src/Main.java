import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        int[][] array = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                array[i][j] = scanner.nextInt();
            }
        }

        int[][] rotateArray = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                rotateArray[j][rows - 1 - i] = array[i][j];
            }
        }

        for (final int[] ints : rotateArray) {
            for (final int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }

    }
}