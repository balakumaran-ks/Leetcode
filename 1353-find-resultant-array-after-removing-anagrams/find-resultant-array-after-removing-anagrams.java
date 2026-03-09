class Solution {
    private boolean isAnagram(String wrd1,String wrd2){
        char[] a = wrd1.toCharArray();
        char[] b = wrd2.toCharArray();
        int l1 = a.length;
        int l2 = b.length;

        if(l1!=l2)return false;

        Arrays.sort(a);
        Arrays.sort(b);

        for(int i=0;i<l1;i++)
        if(a[i]!=b[i])return false;

        return true;
    }

    public List<String> removeAnagrams(String[] words) {
        List<String> ans=  new ArrayList<>();
        int len = words.length;
        ans.add(words[0]);
        for(int i=1;i<len;i++){
            if(!isAnagram(words[i-1],words[i]))
            ans.add(words[i]);
        }
        return ans;
    }
}