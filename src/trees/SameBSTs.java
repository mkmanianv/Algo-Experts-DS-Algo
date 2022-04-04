package trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SameBSTs {
    public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {
        if(arrayOne.size() != arrayTwo.size()){
            return false;
        }

        if(arrayOne.size() == 0 && arrayTwo.size() == 0){
            return true;
        }

        if(arrayOne.get(0).intValue() != arrayTwo.get(0).intValue()){
            return false;
        }


        List<Integer> smallestOne = smallest(arrayOne);
        List<Integer> smallestTwo = smallest(arrayTwo);
        List<Integer> greaterOrEqualOne = greaterOrEqual(arrayOne);
        List<Integer> greaterOrEqualTwo = greaterOrEqual(arrayTwo);


        return sameBsts(smallestOne, smallestTwo) && sameBsts(greaterOrEqualOne, greaterOrEqualTwo);
    }

    public static List<Integer> smallest(List<Integer> array){
        List<Integer> smallest = new ArrayList<>();
        for(int i=1; i< array.size();i++){
            if(array.get(i).intValue() < array.get(0).intValue()){
                smallest.add(array.get(i).intValue());
            }
        }
        return smallest;
    }

    public static List<Integer> greaterOrEqual(List<Integer> array){
        List<Integer> greaterOrEqual = new ArrayList<>();
        for(int i=1; i< array.size();i++){
            if(array.get(i).intValue() >= array.get(0).intValue()){
                greaterOrEqual.add(array.get(i).intValue());
            }
        }
        return greaterOrEqual;
    }

    public static void main(String[] args) {
        List<Integer> arrayOne = new ArrayList<Integer>(Arrays.asList(10, 15, 8, 12, 94, 81, 5, 2, 11));
        List<Integer> arrayTwo = new ArrayList<Integer>(Arrays.asList(10, 8, 5, 15, 2, 12, 11, 94, 81));
        System.out.println(SameBSTs.sameBsts(arrayOne, arrayTwo));
    }
}
