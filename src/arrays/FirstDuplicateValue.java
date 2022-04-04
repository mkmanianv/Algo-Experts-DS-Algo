package arrays;

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
    
    public int findDuplicate1(int[] array) {
        // Find the intersection point of the two runners.
        int tortoise = array[0];
        int hare = array[0];
        do {
            tortoise = array[tortoise];
            hare = array[array[hare]];
        } while (tortoise != hare);

        // Find the "entrance" to the cycle.
        tortoise = array[0];
        while (tortoise != hare) {
            tortoise = array[tortoise];
            hare = array[hare];
        }

        return hare;
    }

    public static void main(String[] args) {
        int[] input = new int[]{2, 1, 5, 2, 3, 3, 4};
        System.out.println(firstDuplicateValue(input));
        System.out.println(firstDuplicateValue1(input));

    }
}
