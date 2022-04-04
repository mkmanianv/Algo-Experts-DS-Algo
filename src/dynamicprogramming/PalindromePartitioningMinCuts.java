package dynamicprogramming;

public class PalindromePartitioningMinCuts {

    public static int palindromePartitioningMinCuts(String str) {
        boolean[][] dp=new boolean[str.length()][str.length()];
        for(int i=0;i<str.length();i++){
            dp[i][i]=true;
        }

        for(int length =2 ;length < str.length()+1;length++){
            for(int i=0;i<str.length() -length+1;i++){
                int j=i+length -1;
                if(length ==2){
                    dp[i][j]=str.charAt(i) == str.charAt(j);
                }else{
                    dp[i][j]=(str.charAt(i) == str.charAt(j)) && (dp[i+1][j-1]);
                }

            }
        }
        int n= str.length();
        int[] cuts = new int[n];
        for(int i=0; i<n; i++)
        {
            int temp = Integer.MAX_VALUE;
            if(dp[0][i])
                cuts[i] = 0;
            else
            {
                //move ptr j from 0 to i
                for(int j=0; j<i; j++)
                {
                    //move the split ptr for every j and check in dp table whether 2nd split is palindrome.
                    if((dp[j+1][i]) && temp > cuts[j] + 1)
                    {
                        temp = cuts[j] + 1;
                    }
                }
                cuts[i] = temp;
            }
        }
        return cuts[n-1];
    }

    public static void main(String[] args) {
        new PalindromePartitioningMinCuts().palindromePartitioningMinCuts("noonabbad");
    }
}
