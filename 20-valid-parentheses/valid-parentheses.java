class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(')st.push(')');
            else if(s.charAt(i)=='[')st.push(']');
            else if(s.charAt(i)=='{')st.push('}');
            // else if(s.charAt(i)!=st.pop())return false;
            else{
                if(st.isEmpty())return false;
                else if(st.pop()!=s.charAt(i))return false;
            }
        }
        if(st.isEmpty())return true;
        else return false;
    }
}