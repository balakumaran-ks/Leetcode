class Solution {
    public int findClosestNumber(int[] nums) {
        int ans = -100009;
        for(int num:nums){
            if(Math.abs(ans)>Math.abs(num))ans=num;
            if(Math.abs(ans)==Math.abs(num) && num>=0)ans = num;
        }
        return ans;
        
    }
}