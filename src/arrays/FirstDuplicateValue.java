import java.util.HashSet;

public class FirstDuplicateValue {

    // O(n) time | O(n) space
    public static int firstDuplicateValue(int[] array) {
        HashSet<Integer> map = new HashSet<>();
        for (int i : array) {
            if (map.contains(i)) {
                return i;
            } else {
                map.add(i);
            }
        }

        return -1;
    }

    // O(n) time | O(1) space
    public static int firstDuplicateValue1(int[] array) {
        for (int i : array) {
            int abs = Math.abs(i);
            if (array[abs - 1] < 0) return abs;
            array[abs - 1] *= -1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] input = new int[]{2, 1, 5, 2, 3, 3, 4};
        System.out.println(firstDuplicateValue(input));
        System.out.println(firstDuplicateValue1(input));

    }
}
