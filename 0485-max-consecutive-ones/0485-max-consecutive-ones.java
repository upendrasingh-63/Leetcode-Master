class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int left=0;
        int right=0;
        int n=nums.length;
        int max=0;

        while(right<n){
            if(nums[right]==1){
                right++;
            }else{
                max=Math.max(max,right-left);
                left=right;
                right++;
            }
            while(left<right&&nums[left]==0){
                left++;
            }
        }
        max=Math.max(max,right-left);
        return max;
    }
}