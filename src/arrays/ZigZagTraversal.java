package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZigZagTraversal {

    public static List<Integer> zigzagTraverse(List<List<Integer>> array) {
        int height = array.size() - 1;
        int width = array.get(0).size()-1;
        List<Integer> result =new ArrayList<>();
        int row = 0;
        int col = 0;
        boolean goingDown = true;
        while(!isOutOfBounds(row, col, height, width)){
            result.add(array.get(row).get(col));
            if(goingDown){ //move first col down and last row right
                if(col == 0 || row == height){
                    goingDown = false;
                    if(row == height){
                        col++; // move right from 13 --> 14
                    }else{
                        row++; // move down from 1 --> 2 or 6 --> 7
                    }
                }else{
                    // diagonal traversal from top to bottom
                    row++;
                    col--;
                }
            }
            else{ // move first row right and last column down
                if(row == 0 || col == width){
                    goingDown = true;
                    if(col == width){
                        row++; // move right from 3 --> 4
                    }else{
                        col++; // move down from 10 --> 11
                    }
                }else{
                    // diagonal traversal from bottom to top
                    col++;
                    row--;
                }
            }

        }
        return result;
    }
    public static boolean isOutOfBounds(int row, int col, int height, int width){
        return (row < 0 || row > height || col < 0 || col > width);
    }

    public static void main(String[] args) {
        List<List<Integer>> test = new ArrayList<>();
        test.add(new ArrayList<>(Arrays.asList(1, 3, 4, 10)));
        test.add(new ArrayList<>(Arrays.asList(2, 5, 9, 11)));
        test.add(new ArrayList<>(Arrays.asList(6, 8, 12, 15)));
        test.add(new ArrayList<>(Arrays.asList(7, 13, 14, 16)));
        System.out.println(zigzagTraverse(test));
    }
}
