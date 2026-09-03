class Solution {
    public String minWindow(String s, String t) {

        //what we need storing freq of t
        int[] need=new int[128];

        //what we have in current window
        int[] window=new int[128];

        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            need[ch]++;
        }

        // what we have what required for current window
        int have=0;
        int required=t.length();

        //start for trach minlen string starting storing result
        int left=0;
        int minlen=Integer.MAX_VALUE;
        int start=0;

        for(int right=0;right<s.length();right++){
            char ch=s.charAt(right);

            //increase ch for current window
            window[ch]++;

            //if we get what required incr have
            if(window[ch]<=need[ch]){
                have++;
            }

            //if this then we have valid window note len, start
            while(have==required){

                if(right-left+1<minlen){
                    minlen=right-left+1;
                    start=left;
                }

                //after noting we intentionally shrink from left coz we need min window
                char remove=s.charAt(left);
                window[remove]--;

                //we remove what required so dcrs have
                if(window[remove]<need[remove]){
                    have--;
                }

                //after removing move left forward
                left++;
            }
        }

        if(minlen==Integer.MAX_VALUE) return "";

        return s.substring(start,start+minlen);
    }
}