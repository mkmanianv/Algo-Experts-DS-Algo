package arrays;

import java.util.HashSet;
import java.util.Set;

public class BeautifulNumbers {

    public static void main(String[] args) {
        new BeautifulNumbers().isHappy(18467);

    }



    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while(n != 1 && seen.add(n)) {
            n = getNext(n);
        }

        return n == 1;
    }

    public int getNext(int n) {
        int sum = 0;

        while(n != 0) {
            int digit = n%10;
            sum += digit * digit;
            n = n/10;
        }

        return sum;
    }
}
