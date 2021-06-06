package arrays;

public class Monotonic {

    public static boolean isMonotonic(int[] array) {
        var isNonDecreasing=true;
        var isNonIncreasing=true;
        for(int i=1;i<array.length;++i){
            if(array[i] < array[i-1]){
                isNonDecreasing=false;
            }
            if(array[i] > array[i-1]){
                isNonIncreasing=false;
            }
        }
        return isNonDecreasing || isNonIncreasing;
    }

    public static void main(String[] args) {
        System.out.println(isMonotonic(new int[]{-1, -1, -2, -3, -4, -5, -5, -5, -6, -7, -8, -8, -9, -10, -11}));

    }
}
