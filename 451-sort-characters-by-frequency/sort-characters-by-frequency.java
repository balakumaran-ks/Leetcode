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
        Map<Character,Integer> map = new HashMap<>();
        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        List<Ele> list = new ArrayList<>();
        for(Map.Entry<Character,Integer> e:map.entrySet()){
            Ele obj = new Ele(e.getKey(),e.getValue());
            for(int i=0;i<obj.freq;i++)list.add(obj);
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