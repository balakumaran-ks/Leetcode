class Solution {
    public int findMin(int[] nums) {
        //base case
        if(nums.length==1)return nums[0];
        // 2 pointer + point of dip
        for(int l=0,r=nums.length-1;l<=r;l++,r--){
            //finding point of dip
            if(nums[l]>nums[l+1])return nums[l+1];

            //finding point of rise
            if(nums[r]<nums[r-1])return nums[r];
        }
        return nums[0];
    }
}