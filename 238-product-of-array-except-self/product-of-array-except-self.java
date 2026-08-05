class Solution {
    public int[] productExceptSelf(int[] nums) {
        int mul = 1;
        int zeroCount = 0;
        for(int num:nums){
            if(num==0)zeroCount++;
            else mul*=num;
        }
        int n = nums.length;
        int[] res = new int[n];
        if(zeroCount>1)return res;
        for(int i=0;i<n;i++){
            if(nums[i]==0)res[i]=mul;
            else res[i] = zeroCount==0 ? mul/nums[i] : 0;
        }
        return res;
    }
}