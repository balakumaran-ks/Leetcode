class Solution {
    public int digitFrequencyScore(int n) {
        int cpy = n;
        int res = 0;
        Map<Integer,Integer> map = new HashMap<>();
        while(cpy!=0){
            map.put(cpy%10,map.getOrDefault(cpy%10,0)+1);
            cpy/=10;
        }
        for(int i=1;i<=9;i++)
        if(map.containsKey(i))
        res+=(i*map.get(i));
        return res;
    }
}