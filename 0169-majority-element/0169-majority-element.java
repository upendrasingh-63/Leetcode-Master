class Solution {
    public int majorityElement(int[] nums) {
        //boyer moore- cancel majority element with other element and mejority wala win
        //t[n],s[1]
        int candidate=0;
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(count==0){
                candidate=nums[i];
            }
            if(candidate==nums[i]){
                count++;
            }else{
                count--;
            }
        }
        return candidate;
    }
}