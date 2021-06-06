import java.util.Arrays;

public class ThreeLargestNum {

    public static int[] findThreeLargestNumbers(int[] array) {
        int[] result = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
        for (int i : array) {
            updateArray(result, i);
        }


        return result;
    }

    public static void updateArray(int[] result, int i){
        if(i>result[2]){
            shiftAndUpdate(result, i , 2);
        }else if(i >result[1]){
            shiftAndUpdate(result, i , 1);
        }else if(i >result[0]) {
            shiftAndUpdate(result, i , 0);
        }
    }

    public static void shiftAndUpdate(int[] result, int i, int idx){
        for(int j=0;j<=idx;j++){
            if(j==idx){
                result[j]=i;
            }else{
                result[j]=result[j+1];
            }
        }
    }





    public static void main(String[] args) {
        System.out.println(Arrays.toString(findThreeLargestNumbers(new int[]{141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7})));
    }
}
