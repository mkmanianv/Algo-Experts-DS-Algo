package dynamicprogramming;

public class KadanesAlgorithm {

    public static int kadanesAlgorithm(int[] array) {
        int maxEndHere=array[0];
        int maxSoFar=array[0];

        for(int i=1;i<array.length;i++){
            maxEndHere= Math.max(array[i], maxEndHere+array[i]);
            maxSoFar=Math.max(maxSoFar,maxEndHere);
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] input = {3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4};
        System.out.println(kadanesAlgorithm(input));
    }
}
