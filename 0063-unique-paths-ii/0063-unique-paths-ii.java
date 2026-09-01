class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        
        int[][] dp=new int[m][n];
        
        for(int[] key:dp){
            Arrays.fill(key,-1);
        }

        return solve(0,0,m-1,n-1,dp,obstacleGrid);
    }
    int solve(int i,int j,int m,int n, int[][] dp,int[][] obstacleGrid){
        if(i>m || j>n){
            return 0;
        }

        if(obstacleGrid[i][j]==1){
            return 0;
        }

        if(i==m && j==n){
            return 1;
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        
        int right=solve(i,j+1,m,n,dp,obstacleGrid);
        int left=solve(i+1,j,m,n,dp,obstacleGrid);
        
        return dp[i][j]=right+left;

    }
}