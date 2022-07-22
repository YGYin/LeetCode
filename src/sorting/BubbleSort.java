package sorting;

public class BubbleSort {

    int[] arr = {12, 15, 11, 14, 13};

    void bubbleSort(int[] arr) {
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr[j], arr[j + 1]);
                    flag = true;
                }
            }
            if (!flag)
                break;
        }
    }

    void swap(int a, int b) {
        int temp;
        temp = a;
        a = b;
        b = temp;
    }
}
