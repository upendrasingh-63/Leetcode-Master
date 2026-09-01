class Solution {
    public int uniquePaths(int m, int n) {
        //to add memoization you have to return something other than void
        int[][] dp=new int[m][n];
        
        for(int[] key:dp){
            Arrays.fill(key,-1);
        }

        return solve(0,0,m-1,n-1,dp);
    }

    int solve(int i,int j,int m,int n, int[][] dp){
        if(i>m || j>n){
            return 0;
        }


        if(i==m && j==n){
            return 1;
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        
        int right=solve(i,j+1,m,n,dp);
        int left=solve(i+1,j,m,n,dp);
        
        return dp[i][j]=right+left;

    }
}