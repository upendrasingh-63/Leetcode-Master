class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int key:nums){
            sum+=key;
        }

        if(sum%2!=0){
            return false;
        }

        int tar=sum/2;
        Boolean[][] dp=new Boolean[nums.length][tar+1];

        return solve(0,nums,tar,dp);
    }

    boolean solve(int i,int[] arr,int tar,Boolean[][] dp){
        if(tar==0){
            return true;
        }

        if(tar<0 || i>arr.length-1){
            return false;
        }
        
        if(dp[i][tar]!=null){
            return dp[i][tar];
        }

        boolean take=solve(i+1,arr,tar-arr[i],dp);
        boolean notTake=solve(i+1,arr,tar,dp);

        return dp[i][tar] = take || notTake;
    }
}