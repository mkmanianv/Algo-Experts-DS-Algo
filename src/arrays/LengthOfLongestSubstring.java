package arrays;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        new LengthOfLongestSubstring().lengthOfLongestSubstring("abcabcbb");
    }

    public int lengthOfLongestSubstring(String s) {
        int pointA=0;
        int pointB=0;
        Set<Character> set=new HashSet<>();
        int max=0;

        while(pointB < s.length()){
            if(!set.contains(s.charAt(pointB))){
                set.add(s.charAt(pointB));
                pointB++;
                max=Math.max(set.size(), max);
            }else{
                set.remove(s.charAt(pointA));
                pointA++;
            }
        }
        return max;
    }
}
