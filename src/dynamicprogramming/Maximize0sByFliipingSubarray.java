package dynamicprogramming;

public class Maximize0sByFliipingSubarray {

    // A Kadane's algorithm based solution to find maximum
    // number of 0s by flipping a subarray.
    public static int findMaxZeroCount(int arr[], int n)
    {
        // Initialize max_diff = maximum of (Count of 0s -
        // count of 1s) for all subarrays.
        int max_diff = 0;

        // Initialize count of 0s in original array
        int orig_zero_count = 0;

        // Consider all Subarrays by using two nested two
        // loops
        for (int i=0; i<n; i++)
        {
            // Increment count of zeros
            if (arr[i] == 0)
                orig_zero_count++;

            // Initialize counts of 0s and 1s
            int count1 = 0, count0 = 0;

            // Consider all subarrays starting from arr[i]
            // and find the difference between 1s and 0s.
            // Update max_diff if required
            for (int j = i; j < n; j ++)
            {
                if(arr[j] == 1)
                    count1++;
                else count0++;
                max_diff = Math.max(max_diff, count1 - count0);
            }
        }

        // Final result would be count of 0s in original
        // array plus max_diff.
        return orig_zero_count + max_diff;
    }

    /* Driver program to test above function */
    public static void main(String[] args)
    {
        int arr[] = {0, 1, 0, 0, 1, 1, 0};

        System.out.println(findMaxZeroCount(arr, arr.length));
    }
}
