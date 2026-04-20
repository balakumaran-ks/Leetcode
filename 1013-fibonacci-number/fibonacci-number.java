class Solution {
    //memory
    HashMap<Integer,Integer> map = new HashMap<>();

    public int fib(int n) {
        if(n==0)return 0;
        if(n==2 || n==1)return 1;
        if(map.containsKey(n))return map.get(n);
        int result = fib(n-1)+fib(n-2);
        map.put(n,result);
        return result;
    }
}