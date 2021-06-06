package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumberSum {

    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        Arrays.sort(array);

        ArrayList<Integer[]> integers = new ArrayList<>();
        for (int i = 0; i < array.length - 2; i++) {
            int leftPointer = i + 1;
            int rightPointer = array.length - 1;
            while (leftPointer < rightPointer) {
                int currentSum = array[i] + array[leftPointer] + array[rightPointer];
                if (currentSum == targetSum) {
                    integers.add(new Integer[]{array[i], array[leftPointer], array[rightPointer]});
                    leftPointer++;
                    rightPointer--;
                } else if (currentSum < targetSum) {
                    leftPointer++;
                } else if (currentSum > targetSum) {
                    rightPointer--;
                }
            }


        }
        return integers;
    }

    public static void main(String[] args) {
        System.out.println(threeNumberSum(new int[]{12, 3, 1, 2, -6, 5, -8, 6}, 0));
    }
}
