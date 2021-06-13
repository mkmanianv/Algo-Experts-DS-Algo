package Trees;

public class BinarySearch {

    public static int binarySearch(int[] array, int target) {
        return binaryserach(array, target, 0, array.length-1);
    }

    public static int binaryserach(int[] array, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        int pivot = (end + start) / 2;
        int pivotElement = array[pivot];
        if (target == pivotElement) {
            return pivot;
        } else if (target > pivotElement) {
            start = pivot;
            return binaryserach(array, target, start+1, end);
        } else {
            end = pivot;
            return binaryserach(array, target, start, end-1);
        }
    }


    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{1, 5, 23, 111}, 35));
    }
}
