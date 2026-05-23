class Solution {
    public boolean check(int[] nums) {
        int pod = -1; //point of dip
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]){pod = i+1;break;}
        }
        if(pod==-1)return true;
        for(int i=pod;(i-pod)<nums.length-1;i++){
            if(nums[(i%nums.length)]>nums[((i+1)%nums.length)])return false;
        }
        return true;
    }
}