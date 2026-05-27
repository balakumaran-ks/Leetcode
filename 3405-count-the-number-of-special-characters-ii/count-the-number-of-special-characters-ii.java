class Solution {
    public int numberOfSpecialChars(String word) {
        int res = 0;
        int[] ans = new int[26];
        int[] lower = new int[26];
        int[] higher = new int[26];
        char c = '"';
        for(int i=0;i<word.length();i++){
            c = word.charAt(i);

            //lowercase
            if(c<='z' && c>='a'){
                lower[c-'a']=1;
                if(higher[(c-32)-'A']!=0){
                    ans[c-'a']=-1;
                }
            }
            else //upper case
            {
                if(higher[c-'A']==1)continue;
                higher[c-'A']=1;
                if(lower[(c+32)-'a']==1 && ans[(c+32)-'a']!=-1){
                    ans[(c+32)-'a']=1;
                }
            }
        }
        for(int i=0;i<26;i++)if(ans[i]==1)res++;
        return res;
    }
}