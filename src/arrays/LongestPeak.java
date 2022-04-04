package arrays;

public class LongestPeak {

    public static int longestPeak(int[] array) {
        int lengthOfLongestPeak = 0;
        int j = 1;
        int arrayLength = array.length - 1;
        while (j < arrayLength) {
            boolean isPeak = array[j - 1] < array[j] && array[j + 1] < array[j];

            if (!isPeak) {
                j++;
                continue;
            }
            int leftIdx = j - 2;
            while (leftIdx > 0 && array[leftIdx] < array[leftIdx + 1]) {
                leftIdx--;
            }

            int rightIdx = j + 2;
            while (rightIdx < arrayLength && array[rightIdx] < array[rightIdx - 1]) {
                rightIdx++;
            }
            int currentLongestPeak = rightIdx - leftIdx - 1;
            if (currentLongestPeak > lengthOfLongestPeak) {
                lengthOfLongestPeak = currentLongestPeak;
            }
            j = rightIdx;
        }

        return lengthOfLongestPeak;
    }

    public static void main(String[] args) {

        int[] input = new int[]{1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3};
        System.out.println(longestPeak(input));

    }
}
