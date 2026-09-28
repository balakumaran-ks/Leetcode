class Solution {
    public int maxDepth(String s) {
        int res = 0;
        Stack<Character> st = new Stack<>();
        for(char c:s.toCharArray()){
            if(c=='(')st.add(c);
            else if(c==')'){
                res = Math.max(res , st.size());
                st.pop();
            }
        }
        return res;
    }
}