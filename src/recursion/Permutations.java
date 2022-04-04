package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

    public static List<List<Integer>> getPermutations(List<Integer> array) {
        List<List<Integer>> permutations = new ArrayList<List<Integer>>();
        getPermutations(array, new ArrayList<Integer>(), permutations);
        return permutations;
    }

    public static void getPermutations(
            List<Integer> array, List<Integer> currentPerm, List<List<Integer>> permutations){
        if(array.size()==0 && currentPerm.size()>0){
            permutations.add(currentPerm);
        }else{
            for(int i=0;i<array.size();i++){
                List<Integer> newArray = new ArrayList<>(array);
                newArray.remove(i);
                List<Integer> newPrem = new ArrayList<>(currentPerm);
                newPrem.add(array.get(i));
                getPermutations(newArray,newPrem, permutations);

            }
        }
    }

    public static void main(String[] args) {
        List<Integer> input = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
        List<List<Integer>> perms = Permutations.getPermutations(input);
        System.out.println(perms);
    }
}
