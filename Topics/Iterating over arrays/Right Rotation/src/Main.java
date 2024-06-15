import java.util.List;
import java.util.Scanner;
import java.util.Arrays;
import java.util.stream.Collectors;

class Main {
    // implement me
    private static void rotate(int[] arr, int steps) {
        int aux = arr[0];
        int cursor = 0;

        for (int i = 0; i < arr.length; i++) {
            final int value = arr[(cursor + steps) % arr.length];
            arr[(cursor + steps) % arr.length] = aux;
            aux = value;
            cursor = cursor + steps;
        }
    }

    private static void rotate2(int[] arr, int steps) {
        List<Integer> originalArr = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.toList());

        int size = originalArr.size();
        int rotation = steps % size;
        if (rotation > 0) {
            List<Integer> front = originalArr.subList(0, rotation);
            List<Integer> back = originalArr.subList(rotation, size);
            back.addAll(front);
            originalArr = back;
            Arrays.setAll(arr, originalArr::get);
        }
    }

    // do not change code below
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int steps = Integer.parseInt(scanner.nextLine());

        rotate(arr, steps);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}