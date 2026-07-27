class Solution {
    public void sortColors(int[] arr) {
    //     arr[mid] == 0
    //     swap(arr[low], arr[mid])
    //     low++
    //     mid++

    // arr[mid] == 1
    //     mid++

    // arr[mid] == 2
    //     swap(arr[mid], arr[high])
    //     high--

        int low=0;
        int mid=0;
        int n=arr.length;
        int high=n-1;

        while(mid<=high){
            if(arr[mid]==0){
                int temp=arr[low];
                arr[low]=arr[mid];
                arr[mid]=temp;
                mid++;
                low++;
            }else if(arr[mid]==1){
                mid++;
            }else{
                int temp=arr[mid];
                arr[mid]=arr[high];
                arr[high]=temp;
                high--;
            }
        }
    }
}