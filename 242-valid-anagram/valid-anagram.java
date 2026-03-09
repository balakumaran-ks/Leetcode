class Solution {
    public boolean isAnagram(String s, String t) {
        char[] str = s.toCharArray();
        char[] pat = t.toCharArray();
        int s_len = str.length;
        int t_len = pat.length;

        if(s_len!=t_len)return false;

        Arrays.sort(str);
        Arrays.sort(pat);

        for(int ch=0;ch<s_len;ch++)
        if(str[ch]!=pat[ch])return false;
        
        return true;
    }
}