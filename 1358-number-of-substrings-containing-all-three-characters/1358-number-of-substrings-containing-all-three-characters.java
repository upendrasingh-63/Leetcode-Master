class Solution {
    public int numberOfSubstrings(String s) {

        // last occuring index of each 3 character
        int[] arr={-1,-1,-1};

        int count=0;

        //how many valid substrings are ending at right
        for(int right=0;right<s.length();right++){
            arr[s.charAt(right)-'a']=right;

            int min=Math.min(arr[0],Math.min(arr[1],arr[2]));

            count+=min+1;
        }
        return count;
    }
}