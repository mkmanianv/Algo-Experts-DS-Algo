package dynamicprogramming;

public class PalindromicSubstring {

    public int countSubstrings(String s)
    {
        int count =0;
        for (int i = 0; i < s.length(); i++)
        {
            // find all odd length palindrome with str[i] as mid point
            count += expand(s,i,i);
            // find all even length palindrome with str[i] and str[i+1] as its mid points
            count +=expand(s,i,i+1);
        }

        return count;

    }

    // expand in both directions of low and high to find all palindromes

    public int expand(String s,int low,int high)
    {
        // run till str[low.high] is a palindrome
        int count = 0;
        while(low >=0 && high<s.length() && s.charAt(low) == s.charAt(high))
        {
            count++;
            low--;
            high++;
        }

        return count;

    }

    public static void main(String[] args) {
        System.out.println(new PalindromicSubstring().countSubstrings("abcabc"));
    }
}
