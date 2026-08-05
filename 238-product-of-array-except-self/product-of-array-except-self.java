class Solution {
    public int[] productExceptSelf(int[] nums) {
        int mul = 1;
        int zeroCount = 0;
        int zeroIndex = -1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
             zeroCount++;
             zeroIndex=  i;
             if(zeroCount>1)break; 
            }
            else mul*=nums[i];
        }
        int n = nums.length;
        int[] res = new int[n];
        if(zeroCount>1)return res;
        if(zeroIndex!=-1){
            res[zeroIndex]=mul;
            return res;
        }
        for(int i=0;i<n;i++){
            res[i] = mul/nums[i] ;
        }
        return res;
    }
}