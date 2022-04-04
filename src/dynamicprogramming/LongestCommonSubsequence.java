package dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonSubsequence {

    public static List<Character> longestCommonSubsequence(String str1, String str2) {
        int[][] dp=new int[str1.length()+1][str2.length()+1];
        for(int i=1;i < str1.length()+1;i++){
            for(int j=1;j < str2.length()+1;j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j]= dp[i-1][j-1] +1;
                }else{
                    dp[i][j]= Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return build(dp, str2);
    }
    public static List<Character> build(int[][] dp, String str){
        List<Character> result = new ArrayList<>();
        int i= dp.length-1;
        int j= dp[0].length-1;
        while(i!=0&&j!=0){
            //  top cell and current cell is equal the traverse top
            if(dp[i][j] == dp[i-1][j]){
                i--;
                //  left cell and current cell is equal the traverse left
            }else if (dp[i][j] == dp[i][j-1]){
                j--;
                // traverse diagonal and add the j to list
            }else{
                result.add(0, str.charAt(j-1));
                i--;
                j--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        new LongestCommonSubsequence().longestCommonSubsequence("abcdaf","acbcf");
    }
}
