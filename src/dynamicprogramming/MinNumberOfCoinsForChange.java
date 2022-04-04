package dynamicprogramming;

import java.util.Arrays;

public class MinNumberOfCoinsForChange {

    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        int[] coins =new int[n+1];
        Arrays.fill(coins, Integer.MAX_VALUE);
        coins[0]=0;
        for(int denom: denoms){
            for (int amount=0;amount<coins.length;amount++){
                if(denom<=amount){
                    if(coins[amount-denom]==Integer.MAX_VALUE){
                        coins[amount]=Math.min(coins[amount], coins[amount-denom]);
                    }else {
                        coins[amount] = Math.min(coins[amount], 1 + coins[amount - denom]);
                    }
                }

            }
        }

        return coins[n]!=Integer.MAX_VALUE? coins[n]:-1;
    }

    public int coinChange(int[] coins, int amount)
    {
        if(amount < 0)
            return -1;
        if(amount == 0)
            return 0;
        int max = amount+1;
        int[] dp = new int[max];
        Arrays.fill(dp,max);
        dp[0]=0;
        for(int i=1;i<=amount;i++)
        {
            for(int j=0;j<coins.length;j++)
            {
                if(coins[j]<=i)
                {
                    dp[i]=Math.min(dp[i],dp[i-coins[j]]+1);

                }
            }
        }
        return dp[amount]>amount?-1:dp[amount];
    }

    public static void main(String[] args) {
//        minNumberOfCoinsForChange(7, new int[]{2,4});
        new MinNumberOfCoinsForChange().coinChange(new int[]{2,4}, 7);
    }
}
