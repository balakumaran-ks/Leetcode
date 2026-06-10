class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.equals(""))return 0;
        if(s.length()==1)return 1;
        int res = 0;
        Set<Character> set =  new HashSet<>();
        int right=0;
        int left=0;
        while(right<s.length()){
            if(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
                continue;
            }
            set.add(s.charAt(right));
            res = Math.max(res , s.substring(left,right).length());
            right++;
        }
        return res+1;
    }
}