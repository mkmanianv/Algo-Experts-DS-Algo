package dynamicprogramming;

import java.util.Arrays;

public class MinNumberOfJumps {
    public static int minNumberOfJumps(int[] array) {
        int[] jumps = new int[array.length];
        Arrays.fill(jumps, Integer.MAX_VALUE);
        jumps[0]=0;
        for(int i=1; i<array.length;i++){
            for(int j=0; j<i;j++){
                if(array[j] >= i-j){
                    jumps[i]=Math.min(jumps[i], jumps[j]+1);
                }
            }
        }
        return jumps[jumps.length-1];
    }

    public static int minNumberOfJumpsOptimized(int[] array) {
        if(array.length == 1) return 0;
        int[] dp = new int[array.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[array.length-1]=0;
        for(int i=array.length-2;i>=0;i--) {
            int min = Integer.MAX_VALUE;
            for(int j=i+1;j<=Math.min(i + array[i], array.length-1); j++) {
                if (dp[j] == Integer.MAX_VALUE) continue;
                if(1 + dp[j] < min) {
                    min = 1 + dp[j];
                }
            }
            dp[i] = min;
        }
        return dp[0];
    }

    public int minNumberOfJumpsOptimized1(int[] nums) {
        int limit = -1, start=0, end = 0, jump = 0;
        while(end<nums.length-1){
            int tempEnd = max(nums,start,end);
            start = end;
            end = tempEnd;
            jump++;
        }
        return jump;
    }

    public int max(int[] arr, int start, int end){
        int max = start;
        for(int i=start;i<=end;i++){
            int temp = i+arr[i];
            max = max<temp?temp:max;
        }
        return max;
    }

    public static void main(String[] args) {
        new MinNumberOfJumps().minNumberOfJumpsOptimized1(new int[]{3, 4, 2, 1, 2, 3, 7, 1, 1, 1, 3});
    }
}
