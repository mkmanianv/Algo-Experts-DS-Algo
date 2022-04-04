package dynamicprogramming;

public class MaxSubsetSumNoAdjacent {

    public static int maxSubsetSumNoAdjacent(int[] array) {
        if(array.length==0){
            return 0;
        }
        if(array.length==1){
            return array[0];
        }
        int maxSumi_2= array[0];
        int maxSumi_1 = Math.max(array[0], array[1]);
        for (int i=2; i <array.length;i++){
            int currentMax= Math.max(maxSumi_1, maxSumi_2+array[i]);
            maxSumi_2=maxSumi_1;
            maxSumi_1=currentMax;
        }
        return maxSumi_1;
    }

    public static void main(String[] args) {

    }
}
