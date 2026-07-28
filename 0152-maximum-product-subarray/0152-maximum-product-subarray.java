class Solution {
    public int maxProduct(int[] arr) {
        //make maxtillhere, mintillhere, arr[i], tak max of all

        int min=arr[0];
        int max=arr[0];
        int ans=arr[0];

        for(int i=1;i<arr.length;i++){
            if(arr[i]<0){
                //flip min max for max neg prod
                int temp=min;
                min=max;
                max=temp;
            }

            min=Math.min(arr[i],arr[i]*min);// current or previous
            max=Math.max(arr[i],arr[i]*max);

            ans=Math.max(ans,max);
        }

        return ans;
    }
}