package arrays;

import java.util.Arrays;
// two pointer concept
public class SmallDifference {

    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        //sort the arrays
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);
        int indexOne=0;
        int indexTwo=0;
        int smallest= Integer.MAX_VALUE;
        int current;
        int[] smallestPair= new int[2];
        while(indexOne < arrayOne.length && indexTwo < arrayTwo.length){
            int firstNum=arrayOne[indexOne];
            int secondNum=arrayTwo[indexTwo];
            if(firstNum < secondNum){
                current = secondNum - firstNum;
                indexOne++;
            }else if (secondNum < firstNum){
                current= firstNum - secondNum;
                indexTwo++;
            }else {
                return new int[]{firstNum,secondNum};
            }
            if(smallest>current){
                smallest=current;
                smallestPair=new int[]{firstNum,secondNum};
            }
        }
        return smallestPair;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(SmallDifference.smallestDifference(new int[] {-1, 5, 10, 20, 28, 3}, new int[] {26, 134, 135, 15, 17})));
    }

}
