class FixingExceptions {

    public static void calculateSquare(int[] array, int index) {
        if (array == null || index > array.length - 1 || index < 0) {
            System.out.println("Exception!");
            return;
        }

        System.out.println(array[index] * array[index]);
    }
}