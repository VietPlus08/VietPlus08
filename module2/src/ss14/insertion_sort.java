package ss14;

import java.util.Arrays;

public class insertion_sort {
    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 8, 5, 6, 12, 3};
        insertionSort(arr);
    }

    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                } else {
                    break;
                }
            }
            System.out.printf("After loop %d: ", i);
            showAllElementInArray(arr);
        }
    }
    private static void showAllElementInArray(int[] arr){
        System.out.println(Arrays.toString(arr));
    }
}
