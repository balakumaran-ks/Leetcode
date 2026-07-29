class Ele{
    int freq;
    char c;
    Ele(char ch,int f){
        c=ch;
        freq = f;
    }
}

class Solution {
    public String frequencySort(String s) {
        int[] caps = new int[26];
        int[] small = new int[26];
        int[] digits  = new int[10];
        for(char c:s.toCharArray()){
            if(c<='z'&&c>='a')small[c-'a']++;
            else if(c>='A' && c<='Z')caps[c-'A']++;
            else digits[c-'0']++;
        }
        List<Ele> list = new ArrayList<>();
        for(int i=0;i<26;i++){
            if(small[i]!=0){
                char c =(char) ('a'+ i);
                Ele obj = new Ele(c,small[i]);
                for(int j=0;j<small[i];j++)list.add(obj);
            }
            if(caps[i]!=0){
                char c = (char)(i+'A');
                Ele obj = new Ele(c,caps[i]);
                for(int j=0;j<caps[i];j++)list.add(obj);
            }
        }
        for(int i=0;i<10;i++){
            if(digits[i]!=0){
                char c = (char)('0'+i);
                Ele obj = new Ele(c,digits[i]);
                for(int j=0;j<digits[i];j++)list.add(obj);
            }
        }

        Collections.sort(list , (a,b)->{
            return b.freq - a.freq;
        });
        StringBuilder res = new StringBuilder();
        for(Ele e:list){
            res.append(e.c);
        }
        return res.toString();
    }
}