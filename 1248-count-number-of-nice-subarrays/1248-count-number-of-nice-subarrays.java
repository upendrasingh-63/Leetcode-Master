class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        //excatly k=atmost k- atmost (k-1)
        //for each count window size and return then subtract
        return atMost(nums,k)-atMost(nums,k-1);
    }

    int atMost(int[] nums, int k){
        if(k<0) return 0;

        int left=0;
        int count=0;
        int odd=0;

        for(int right=0;right<nums.length;right++){
            if(nums[right]%2!=0){
                odd++;
            }
            
            while(odd>k){
                if(nums[left]%2!=0){
                    odd--;
                }
                left++;
            }

            count+=right-left+1;
        }

        return count;
    }
}