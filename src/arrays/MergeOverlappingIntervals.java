package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeOverlappingIntervals {


    public static int[][] mergeOverlappingIntervals(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int[] currentInterval = intervals[0];
        result.add(currentInterval);
        for (int[] interval : intervals) {
            int currentIntervalEnd = currentInterval[1];
            int nextIntervalStart = interval[0];
            int nextIntervalEnd = interval[1];

            if (currentIntervalEnd >= nextIntervalStart) {
                currentInterval[1] = Math.max(currentIntervalEnd, nextIntervalEnd);
            } else {
                currentInterval = interval;
                result.add(currentInterval);
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {

        int[][] input = {
                {1, 2},
                {3, 5},
                {4, 7},
                {6, 8},
                {9, 10}
        };
        System.out.println(Arrays.toString(mergeOverlappingIntervals(input)));

    }
}
