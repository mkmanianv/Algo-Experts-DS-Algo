package arrays;

public class LongestPalindrome {

    public String longestPalindrome(String s) {
        int si =0;
        int ei =0;
        boolean [][] dp = new boolean [s.length()][s.length()];

        for(int len = 1; len<= s.length(); len++){

            for(int row=0, col = len-1; col< s.length(); col++, row++){
                if(len<=2){
                    dp[row][col] = s.charAt(row) == s.charAt(col);
                }else {
                    dp[row][col] = s.charAt(row) == s.charAt(col) && dp[row+1][col-1];
                }
                if(dp[row][col] && (ei -si < col+1-row)){
                    si = row;
                    ei = col+1;
                }
            }
        }
        return s.substring(si, ei);
    }

    public String longestPalindrome1(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public static void main(String[] args) {
        new LongestPalindrome().longestPalindrome("babad");
    }
}
