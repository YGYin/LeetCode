public class CountMin {

    private int h1(int x) {
        return (2 * x + 3) % 7;
    }

    private int h2(int x) {
        return (3 * x + 1) % 7;
    }

    public static void main(String[] args) {
        int[] arr = {6, 5, 8, 9, 4,
                2, 4, 3, 8, 6,
                8, 3, 7, 5, 8,
                7, 2, 3, 4, 6,
                5, 9, 4, 3, 8,
                4, 8, 3, 1, 7,
                8, 3, 9};
        int[] h1_arr = new int[7];
        int[] h2_arr = new int[7];
        CountMin countMin = new CountMin();
        for (int i = 0; i < arr.length; i++) {
            int hash1 = countMin.h1(arr[i]);
            h1_arr[hash1]++;
            int hash2 = countMin.h2(arr[i]);
            h2_arr[hash2]++;
        }

        System.out.println("C[0][0-6]:");
        for (int i = 0; i < 7; i++)
            System.out.println("index " + i + " -> " + h1_arr[i]);
        System.out.println("C[1][0-6]:");
        for (int i = 0; i < 7; i++)
            System.out.println("index " + i + " -> " + h2_arr[i]);
    }
}
