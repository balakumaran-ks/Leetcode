class Solution {
    Map<Integer,Integer> map = new HashMap<>();
    public int fib(int n) {
        if(map.containsKey(n))return map.get(n);
        if(n==0)return 0;
        if(n==1||n==2)return 1;
        int res = fib(n-1)+fib(n-2);
        map.put(n,res);
        return res;
    }
}