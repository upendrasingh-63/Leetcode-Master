class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;

        int[] dp=new int[n];
        int[] parent =new int[n];

        Arrays.fill(dp,1);
        Arrays.fill(parent, -1);

        int lastIndex=0;
        int maxLen=1;

        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0 && dp[j]+1>dp[i]){
                    dp[i]=dp[j]+1;
                    parent[i]=j;
                }
            }

            if(dp[i]>maxLen){
                maxLen=dp[i];
                lastIndex=i;
            }
        }

        List<Integer> list=new ArrayList<>();

        while(lastIndex!=-1){
            list.add(nums[lastIndex]);
            lastIndex=parent[lastIndex];
        }

        return list;
    }
}