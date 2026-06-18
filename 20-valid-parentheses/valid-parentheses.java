class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c:s.toCharArray()){
            if(c=='(')stack.push(')');
            else if(c=='[') stack.push(']');
            else if(c=='{') stack.push('}');
            else{
                if(stack.isEmpty())return false;
                if(stack.pop()!=c)return false;
            }
        }
        if(stack.isEmpty()==false)return false;
        return true;
    }
}