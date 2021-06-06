package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoveElementToEnd {

    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        if(array.isEmpty()){
            return array;
        }
        int indexStart = 0;
        int indexEnd = array.size() - 1;
        while(indexStart < indexEnd){
            Integer indexStartValue = array.get(indexStart);
            Integer indexStartEnd = array.get(indexEnd);
            if(!indexStartValue.equals(toMove)){
                indexStart++;
            }
            if(indexStartEnd.equals(toMove)){
                indexEnd--;
            }
            if(indexStartValue.equals(toMove) && !indexStartEnd.equals(toMove)){
                indexStartValue = indexStartValue - indexStartEnd;
                indexStartEnd = indexStartValue + indexStartEnd;
                indexStartValue = indexStartEnd - indexStartValue;
                array.set(indexStart, indexStartValue);
                array.set(indexEnd, indexStartEnd);
                indexStart++;
                indexEnd--;
            }
        }

        return array;
    }


    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>(Arrays.asList(2, 4, 2, 5, 6, 2, 2));
        List<Integer> output = MoveElementToEnd.moveElementToEnd(array, 2);
        System.out.println(output);
    }
}
