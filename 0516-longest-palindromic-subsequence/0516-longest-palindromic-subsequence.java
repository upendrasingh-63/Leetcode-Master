class Solution {
    public int longestPalindromeSubseq(String s) {
        if(s.length()==0){
            return 0;
        }

        int[][] dp=new int[1000][1000];
        for(int[] key:dp){
            Arrays.fill(key,-1);
        }

        return solve(0,s.length()-1,s,dp);
    }
    int solve(int i, int j, String s,int[][] dp){
        if(i>j){
            return 0;
        }

        if(i==j){
            return 1;
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        if(s.charAt(i)==s.charAt(j)){
            return dp[i][j]= 2+solve(i+1,j-1,s,dp);
        }else{
            return dp[i][j]= Math.max(solve(i+1,j,s,dp),solve(i,j-1,s,dp));
        }
    }
}