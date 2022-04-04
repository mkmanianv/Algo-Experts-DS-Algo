package arrays;

import java.util.ArrayList;
import java.util.List;

public class FindTargetSumWays {

    public int findTargetSumWays(int[] nums, int target) {
        List<String> res = new ArrayList<>();
        solve(nums, 0, target, res, "");
        return res.size();
    }

    public void solve(int[] nums, int index, int target, List<String> res, String exp){
        if(index >= nums.length){
            if(target ==0){
                res.add(exp);
            }
            return;
        }
        solve(nums, index+1, target-nums[index], res, exp);
        solve(nums, index+1, target+nums[index], res, exp);
    }

    public static void main(String[] args) {
        new FindTargetSumWays().findTargetSumWays(new int[]{1,1,1,1,1},3 );
    }
}
