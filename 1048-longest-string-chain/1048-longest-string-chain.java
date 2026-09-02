class Solution {
    public int longestStrChain(String[] arr) {
       int n= arr.length;

        //sorting is compulary 
       Arrays.sort(arr,(a,b)->a.length()-b.length());

       int[] dp=new int[n];

       Arrays.fill(dp,1);

       for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(solve(arr[j],arr[i])){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
       }

       return Arrays.stream(dp).max().orElse(0);
    }

    boolean solve(String s1,String s2){
        if(s2.length()!=s1.length()+1){
            return false;
        }

        int i=0;
        int j=0;

        while(i<s1.length() && j<s2.length()){
            if(s1.charAt(i)==s2.charAt(j)){
                i++;
            }
            j++;
        }
        
        return i==s1.length();
    }
}