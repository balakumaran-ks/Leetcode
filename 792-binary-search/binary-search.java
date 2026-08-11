class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int n = nums.length;
        int high = n;
        while(low<high){
            int mid = low+(high-low)/2;
            if(nums[mid]==target)return mid;
            if(nums[mid]<target)low = mid+1;
            else //if(nums[mid]>target)
            high = mid;
        }
        return -1;
    }
}