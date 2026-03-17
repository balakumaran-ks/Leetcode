class Solution {
    public int lengthOfLastWord(String s) {
        int len = 0;
        int i;
        for(i=s.length()-1;s.charAt(i)==' ';i--);
        if(i==-1)return s.length();
        if(i==s.length()-1 && s.length()<2)return 1;
        while(s.charAt(i)!=' '){
            len++;
            i--;
            if(i<0)break;
        }
        return len;
    }
}