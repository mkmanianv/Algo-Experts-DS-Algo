package arrays;

import java.util.Arrays;

public class SortedSquareArray {


    public static void main(String[] args) {
        SortedSquareArray sortedSquareArray = new SortedSquareArray();
        int[] output = sortedSquareArray.sortedSquaredArray2(new int[]{1, 2, 3, 5, 6, 8, 9});
        System.out.println(output);

    }

    public int[] sortedSquaredArray(int[] array) {
        //Squaring the value
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] * array[i];
        }
        //Sorting the array
        Arrays.sort(array);
        return array;
    }

    public int[] sortedSquaredArray2(int[] array) {
        // iterating in reverse order
        int[] sortedArray = new int[array.length];
        int smallValueIdx = 0;
        int largeValueIdx = array.length - 1;
        for (int i = array.length - 1; i >= 0; i--) {
            int smallValue = array[smallValueIdx];
            int largeValue = array[largeValueIdx];
            if (Math.abs(smallValue) > Math.abs(largeValue)) {
                sortedArray[i] = smallValue * smallValue;
                smallValueIdx++;
            } else {
                sortedArray[i] = largeValue * largeValue;
                largeValueIdx--;
            }

        }
        return sortedArray;
    }

}
