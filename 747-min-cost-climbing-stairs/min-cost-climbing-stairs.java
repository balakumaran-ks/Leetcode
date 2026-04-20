class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] minCost = new int[cost.length];
        minCost[0] = cost[0];
        if(cost.length>2)
        minCost[1] = Math.min(minCost[0]+cost[1],cost[1]);
        else
        minCost[1] = Math.min(minCost[0],cost[1]);
        for(int idx=2;idx<cost.length;idx++){
            if(idx==cost.length-1)
            minCost[idx] = Math.min(minCost[idx-1],minCost[idx-2]+cost[idx]);
            else
            minCost[idx] = Math.min(minCost[idx-1]+cost[idx],minCost[idx-2]+cost[idx]);
        }
        return minCost[cost.length-1];
    }
}