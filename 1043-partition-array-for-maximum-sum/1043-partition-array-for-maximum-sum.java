class Solution {
    int[] dp;
    public int maxSumAfterPartitioning(int[] arr, int k) {
        dp=new int[arr.length];
        Arrays.fill(dp,-1);

        return solve(0,k,arr,dp);
    }

    int solve(int i,int k,int[] arr, int[] dp){

        if(i==arr.length){
            return 0;
        }

        if(dp[i]!=-1){
            return dp[i];
        }

        int ans=0;
        int max=0;

        for(int j=i;j<Math.min(arr.length,i+k);j++){
            max=Math.max(max,arr[j]);

            int window=j-i+1;

            int current=window*max;

            ans=Math.max(ans,current+solve(j+1,k,arr,dp));
        }

        return dp[i]=ans;
    }
}