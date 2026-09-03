class Solution {
    public boolean isScramble(String s1, String s2) {
        if(s1.length()!=s2.length()) return false;

        int n=s1.length();

        Boolean[][][] dp=new Boolean[n][n][n+1];

        return solve(0,0,n,s1,s2,dp);
    }

    boolean solve(int i, int j, int len, String s1, String s2,Boolean[][][] dp){

        //early retrieve
        if(dp[i][j][len]!=null){
            return dp[i][j][len];
        }

        //check including single char
        if(s1.substring(i,i+len).equals(s2.substring(j,j+len))){
            return dp[i][j][len]=true;
        }

        // if single char not same
        if(len==1){
            return false;
        }

        // we have to make non emplty split based on len from k 1 to len-1
        for(int k=1;k<len;k++){

            //no swap
            if(solve(i,j,k,s1,s2,dp) && solve(i+k,j+k,len-k,s1,s2,dp)){
                return dp[i][j][len]= true;
            }

            //swap
            if(solve(i,j+len-k,k,s1,s2,dp) && solve(i+k,j,len-k,s1,s2,dp)){
                return dp[i][j][len]=true;
            }
        }

        return dp[i][j][len]=false;
    }
}