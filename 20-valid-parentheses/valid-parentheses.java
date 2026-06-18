class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Set<Character> open = new HashSet<>();
        open.add('(');
        open.add('[');
        open.add('{');
        for(char c:s.toCharArray()){
            if(open.contains(c)){
                if(c=='(')stack.push(')');
                else if(c=='[') stack.push(']');
                else if(c=='{') stack.push('}');
            }
            else{
                if(stack.isEmpty())return false;
                if(stack.pop()!=c)return false;
            }
        }
        return stack.isEmpty(); 
    }
}