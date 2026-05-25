class Solution {
    public int maxSubArray(int[] nums) {
        int currentSum = 0;
        int bestSum = Integer.MIN_VALUE;
        for(int num:nums){
            currentSum = Math.max(num,currentSum+num);
            bestSum = Math.max(currentSum,bestSum);
        }
        return bestSum;
    }
}