class Solution {
    public boolean isPalindrome(String s) {
        List<Character> list = new ArrayList<>();
        for(char ch:s.toLowerCase().toCharArray()){
            if((ch>='a'&&ch<='z')||(ch>='0'&&ch<='9'))list.add(ch);
        }
        for(int i=0;i<list.size();i++){
            if(i>list.size()-1-i) break;
            if(list.get(i)!=list.get(list.size()-1-i))return false;
        }
        return true;
    }
}