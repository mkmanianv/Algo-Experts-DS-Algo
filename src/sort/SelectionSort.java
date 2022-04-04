package sort;

import java.util.Arrays;

public class SelectionSort {

    public static int[] selectionSort(int[] array) {
        // Write your code here.
        int startIdx=0;
        while( startIdx < array.length -1){
            int smallestIdx=startIdx;
            for(int i = startIdx+1; i< array.length; i++){

                if(array[smallestIdx] > array[i]){
                    smallestIdx =i;
                }
            }
            int temp = array[smallestIdx];
            array[smallestIdx]=array[startIdx];
            array[startIdx]= temp;
            startIdx++;

        }
        return array;
    }

    public static void main(String[] args) {
        int[] input = {8, 5, 2, 9, 5, 6, 3};
        System.out.println(Arrays.toString(selectionSort(input)));
    }
}
