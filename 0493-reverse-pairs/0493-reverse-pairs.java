class Solution {
    public int reversePairs(int[] arr) {
        return mergeSort(arr,0,arr.length-1);
    }

    public int mergeSort(int[] arr,int low,int high){
        if(low>=high)return 0;
        
        int mid=low+(high-low)/2;
        
        int count=0;
        //left ,right, count, merge
        count+=mergeSort(arr,low,mid);
        count+=mergeSort(arr,mid+1,high);
        
        // Count reverse pairs
        count += countPairs(arr, low, mid, high);
        merge(arr,low, mid, high);
        
        return count;
    }

    //count with tow pointers
    private int countPairs(int[] arr, int low, int mid, int high) {

        int count = 0;
        int j = mid + 1;

        for (int i = low; i <= mid; i++) {

            while (j <= high && (long) arr[i] > 2L * arr[j]) {
                j++;
            }

            count += j - (mid + 1);
        }

        return count;
    }

    public void merge(int[] arr, int low, int mid, int high){
        ArrayList<Integer> temp=new ArrayList<>();
        
        int i=low;
        int j=mid+1;
        
        while(i<=mid && j<=high){
            if(arr[i]<=arr[j]){
                temp.add(arr[i]);
                i++;
            }else{
                temp.add(arr[j]);
                j++;
            }
        }
        
        while(i<=mid){
            temp.add(arr[i++]);
        }
        
        while(j<=high){
            temp.add(arr[j++]);
        }
        
        for(int k=low;k<=high;k++){
            arr[k]=temp.get(k-low);
        }
        
    }
}