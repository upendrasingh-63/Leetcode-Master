class Solution {
    public String removeOuterParentheses(String s) {
        int op=1;
        int cl=0;

        Stack<Character> st=new Stack<>();

        for(int i=1;i<s.length()-1;i++){
            char ch=s.charAt(i);

            if(ch=='('){
                op++;
            }else{
                cl++;
            }

            st.push(ch);

            if(op==cl){
                st.pop();
                op=1;
                cl=0;
                i++;
            }
        }

        StringBuilder sb=new StringBuilder();

        while(!st.isEmpty()){
            sb.append(st.pop());
        }

        return sb.reverse().toString();
    }
}