class Solution {
    public int maxProfit(int[] prices) {
        Integer[][][] dp=new Integer[prices.length][2][3];
        return solve(0,1,prices,2,dp);
    }

    //buy==1 you holding stock you can sell or not sell

    int solve(int i, int buy,int[] arr, int transactionLeft,Integer[][][] dp){
        if(i==arr.length || transactionLeft==0){
            return 0;
        }

        if(dp[i][buy][transactionLeft]!=null){
            return dp[i][buy][transactionLeft];
        }

        int ans=0;

        if(buy==1){
            ans =Math.max(-arr[i]+solve(i+1,0,arr,transactionLeft,dp),solve(i+1,1,arr,transactionLeft,dp));
        }else{
            ans= Math.max(arr[i]+solve(i+1,1,arr,transactionLeft-1,dp),solve(i+1,0,arr,transactionLeft,dp));
        }

        return dp[i][buy][transactionLeft]=ans;
    }
}