public class SearchInRotatedArray {
    public static int search(int[] nums, int target) {
        if (nums.length == 1) {
            if (target == nums[0])
                return 0;
            else
                return -1;
        }
        int start = 0;
        int end = nums.length;
        int mid = pivotIndex(nums);
        if (mid > 0 && target >= nums[0] && target <= nums[mid - 1]) {
            return search(nums, target, start, mid - 1);
        } else {
            return search(nums, target, mid, end - 1);
        }
    }

    private static int pivotIndex(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return i;
            }

        }
        return -1;
    }


    private static int search(int[] nums, int target, int start, int end) {
        if (end >= start) {
            int mid = start + (end - start) / 2;
            if (nums.length == mid || mid < 0) {
                return -1;
            }

            // If the element is present at the
            // middle itself
            if (nums[mid] == target)
                return mid;

            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (nums[mid] > target)
                return search(nums, target, start, mid - 1);

            // Else the element can only be present
            // in right subarray
            return search(nums, target, mid + 1, end);
        }

        // We reach here when element is not present
        // in array
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,4,6};
        int target = 1;
        System.out.println(search(nums, target));
    }
}