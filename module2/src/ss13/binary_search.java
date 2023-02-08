package ss13;

import java.util.Arrays;

public class binary_search {
    public static final int NOT_FOUND = -1;

    public static void main(String[] args) {
        int[] ints = {1, 5, 2, 8, 4, 18, 14, 12};
        Arrays.sort(ints);
        int result = binarySearch(18, ints, 0, ints.length - 1);
        System.out.println("Index: " + result);
    }

    private static int binarySearch(int data, int[] ints, int begin, int end) {
        int mid = (begin + end) / 2;
        if (begin > end) {
            return NOT_FOUND;
        }
        if (ints[mid] == data) {
            return mid;
        }
        if (ints[mid] < data) {
            return binarySearch(data, ints, mid + 1, end);
        }
        if (ints[mid] > data) {
            return binarySearch(data, ints, begin, mid - 1);
        }
        return NOT_FOUND;
    }
}
