package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {

    public static List<List<Integer>> powerset(List<Integer> array) {
        return powerset(array, array.size()-1);
//        List<List<Integer>> subsets = new ArrayList<>();
//        subsets.add(new ArrayList<>());
//        for (Integer element : array) {
//            int length = subsets.size();
//            for (int i = 0; i < length; i++) {
//                List<Integer> currentSubset = new ArrayList<>(subsets.get(i));
//                currentSubset.add(element);
//                subsets.add(currentSubset);
//            }
//        }
//        return subsets;
    }

    public static List<List<Integer>> powerset(List<Integer> array, int idx) {

        if (idx < 0) {
            List<List<Integer>> emptySet = new ArrayList<List<Integer>>();
            emptySet.add(new ArrayList<Integer>());
            return emptySet;

        }

        int ele = array.get(idx);

        List<List<Integer>> subsets = powerset(array, idx - 1);

        int length = subsets.size();

        for (int i = 0; i < length; i++) {
            List<Integer> currentSubset = new ArrayList<Integer>(subsets.get(i));
            currentSubset.add(ele);
            subsets.add(currentSubset);

        }

        return subsets;
    }

    public static void main(String[] args) {
        System.out.println(Subsets.powerset(new ArrayList<Integer>(Arrays.asList(1, 2, 3))));
    }
}
