class Solution {
    public int maxNumberOfBalloons(String text) {
        int res = 0;
        String s = "balloon";
        int[] freq = new int[26];
        for(char c:text.toCharArray()){
            freq[c-'a']++;
        }
        while(true){
            for(char c:s.toCharArray()){
                if(freq[c-'a']==0)return res;
                freq[c-'a']--;
            }
            res++;
        }
        // return res;
    }
}