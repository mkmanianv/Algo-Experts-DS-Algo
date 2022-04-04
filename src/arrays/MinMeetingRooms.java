package arrays;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinMeetingRooms {

    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length == 0) {
            return 0;
        }

        PriorityQueue<Integer> allocator = new PriorityQueue<>(intervals.length, (a1, a2) -> a1 - a2);

        Arrays.sort(intervals, (a1, a2) -> a1[0] - a2[0]);

        allocator.add(intervals[0][1]);

        for(int i=1; i<intervals.length; i++) {

            if(intervals[i][0] >= allocator.peek()) {
                allocator.poll();
            }

            allocator.offer(intervals[i][1]);
        }

        return allocator.size();
    }

    public int minMeetingRooms1(int[][] intervals) {
        int n = intervals.length;

        int[] begin = new int[n];
        int[] end = new int[n];

        for(int i = 0; i < n; i++) {
            begin[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(begin);
        Arrays.sort(end);

        int count = 0;

        int res = 0, i = 0, j = 0;

        while (i < n && j < n) {
            if (begin[i] < end[j]) {
                count++;
                i++;
            } else {
                count--;
                j++;
            }

            res = Math.max(res, count);
        }

        return res;
    }

    public static void main(String[] args) {
        new MinMeetingRooms().minMeetingRooms1(new int[][]{{0,30},{5,10},{15,20}});
    }
}
