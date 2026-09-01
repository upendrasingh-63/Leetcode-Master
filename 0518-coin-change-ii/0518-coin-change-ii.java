// each element can be used multiple time for unbound knapsack so we are forward
class Solution {
    public int change(int amount, int[] coins) {

        int[] dp = new int[amount + 1];

        dp[0] = 1;

        for (int coin : coins) {

            for (int j = coin; j <= amount; j++) {

                dp[j] += dp[j - coin];
            }
        }

        return dp[amount];
    }
}
// class Solution {
//     public int change(int amount, int[] coins) {
//         int[][] dp=new int[coins.length][5001];

//         for(int[] key:dp){
//             Arrays.fill(key,-1);
//         }

//         return solve(0,0,amount,coins,dp);

//     }

//     int solve(int i,int sum, int tar,int[] coins, int[][] dp){
//         if(i==coins.length){
//             return sum==tar?1:0;
//         }

//         if(sum>tar){
//             return 0;
//         }

//         if(sum==tar){
//             return 1;
//         }

//         if(dp[i][sum]!=-1){
//             return dp[i][sum];
//         }

//         int take=solve(i,sum+coins[i],tar,coins,dp);
//         int notTake=solve(i+1,sum,tar,coins,dp);

//         return dp[i][sum]=take+notTake;

//     }
// }