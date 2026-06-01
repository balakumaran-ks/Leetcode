class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int res = 0;
        for(int i=0;i<cost.length;i++){
            if((i+1)%3==0){
                ;
            }else
            res+=cost[cost.length-i-1];
        }
        return res;
    }
}