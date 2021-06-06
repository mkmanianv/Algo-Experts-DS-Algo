package sort;

import java.util.Arrays;

public class InsertionSort {

    public static int[] insertionSort(int[] array) {
        if (array.length == 0) {
            return new int[]{};
        }
        for (int i = 1; i < array.length; i++) {
            int j=i;
            while (j>0 && array[j] < array[j-1]){
                swap(j, j-1, array);
                j--;
            }

        }

        return array;
    }

    public static void swap(int i, int j, int[] array) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

    public static void main(String[] args) {
        int[] input = {8, 5, 2, 9, 5, 6, 3};
        System.out.println(Arrays.toString(insertionSort(input)));
    }
}
