class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length==1)return 1;
        if(nums.length==2){if(nums[0]==nums[1])return 1;else return 2;}
        int slow = 0;
        int fast = 1;
        while(fast!=nums.length){
            if(nums[slow]!=nums[fast]){
                slow++;
                nums[slow]=nums[fast];
            }
            fast++;
        }
        return slow+1;
    }
}