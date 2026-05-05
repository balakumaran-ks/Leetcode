class Solution {
    public int searchInsert(int[] nums, int target) {
        if(target<nums[0])return 0;
        if(target>nums[nums.length-1])return nums.length;
        int start;
        int end;
        int mid;
        start = 0;
        end = nums.length-1;
        mid = (start+end)/2;
        while(nums[mid]!=target && (start < end) && (start+1 != end)){
            if(nums[mid]>target){
                end = mid;
            }else{
                start=mid;
            }
            mid = (start+end)/2;
        }
        if(nums[mid]==target)return mid;
        if(nums[end]>target)return end;
        return start+1;
    }
}