class ArrayOperations {
    public static int[][][] createCube() {
        int[][][] arr = new int[3][3][3];

        for (int i = 0; i < 3; i++) {
            int z = 0;
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    arr[i][j][k] = z++;
                }
            }
        }

        return arr;
    }
}