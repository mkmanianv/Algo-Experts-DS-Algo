package greedyalgorithm;

import java.util.Arrays;

public class MinimumWaitingTime {

    public int minimumWaitingTime(int[] queries) {
        Arrays.sort(queries);
        int previousQueryTime=queries[0];
        int minWaitingTime=0;
        for (int i = 1, queriesLength = queries.length; i < queriesLength; i++) {
            int query = queries[i];
            minWaitingTime+=previousQueryTime;
            previousQueryTime+=query;
        }


        return minWaitingTime;
    }

    public int minimumWaitingTime1(int[] queries) {
        Arrays.sort(queries);
        int minWaitingTime=0;
        for (int i = 0, queriesLength = queries.length; i < queriesLength; i++) {
            int query = queries[i];
            int queriesLeft=queriesLength-(i+1);
            minWaitingTime+=query*queriesLeft;
        }


        return minWaitingTime;
    }

    public static void main(String[] args) {
        int[] queries = new int[] {3, 2, 1, 2, 6};
        int expected = 17;
        System.out.println(expected);
        System.out.println(new MinimumWaitingTime().minimumWaitingTime(queries));
        System.out.println(new MinimumWaitingTime().minimumWaitingTime1(queries));
    }
}
