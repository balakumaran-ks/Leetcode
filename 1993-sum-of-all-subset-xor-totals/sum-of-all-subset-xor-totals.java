class Solution {
    public int subsetXORSum(int[] nums) {
        int ans = 0;
        for(int num:nums)
        ans = ans|num;
        return ans*((int)Math.pow(2,nums.length-1));
    }
}