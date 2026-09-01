class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp=new int[amount+1];
        Arrays.fill(dp,-1);

        int ans=solve(coins, amount, dp);
        return ans==Integer.MAX_VALUE?-1:ans;
    }

    int solve(int[] coins,int amount, int[] dp){
        if(amount==0){
            return 0;
        }

        if(dp[amount]!=-1){
            return dp[amount];
        }

        int ans = Integer.MAX_VALUE;

        for(int key:coins){
            if(key<=amount){
                int result=solve(coins,amount-key,dp);

                if(result!=Integer.MAX_VALUE){
                    ans=Math.min(ans,1+result);
                }
            }

        }

        return dp[amount]=ans;
    }
}