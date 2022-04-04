package arrays;

import java.util.ArrayList;
import java.util.List;

//Input: nums = [1,2,3]
//Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result =new ArrayList<>();
        result.add(new ArrayList<>());

        for (int num : nums) {
            List<List<Integer>> temp = new ArrayList<>();

            for (List<Integer> integers : result) {
                List<Integer> a = new ArrayList<>(integers);
                a.add(num);
                temp.add(a);
            }
            result.addAll(temp);

        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Subsets().subsets(new int[]{1,2,3}));
    }
}
