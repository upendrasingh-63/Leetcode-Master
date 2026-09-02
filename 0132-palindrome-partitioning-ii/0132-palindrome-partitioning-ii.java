class Solution {
    boolean[][] bool;
    int[][] dp;
    public int minCut(String s) {
        int n=s.length();

        bool=new boolean[n][n];
        dp=new int[n][n];

        for(int[] key:dp){
            Arrays.fill(key,-1);
        }

        //we are calculating backward coz s[i j] we want i<=j
        for(int i = n - 1; i >= 0; i--) {
            for(int j = i; j < n; j++) {

                if(s.charAt(i) == s.charAt(j) &&
                (j - i <= 1 || bool[i + 1][j - 1])) {

                    bool[i][j] = true;
                }
            }
        }

        return solve(0,s.length()-1);
    }

    int solve(int i, int j){
        //when single char
        if(i>=j){
            return 0;
        }

        // if substring already palidrome
        if(bool[i][j]){
            return dp[i][j]= 0;
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int ans=Integer.MAX_VALUE;

        for(int k=i;k<j;k++){
            if(bool[i][k]){
                int cost=1+solve(k+1,j);
                ans=Math.min(ans,cost);
            }

        }

        return dp[i][j]= ans;
    }
}