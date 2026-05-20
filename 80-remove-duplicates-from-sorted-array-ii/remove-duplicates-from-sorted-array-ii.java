class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length<=2){
            return nums.length;
        }

        int index = 2;
        for(int second=2;second<nums.length;second++){
            if(nums[second]!=nums[index-2]){
                nums[index]=nums[second];
                index++;
            }
        }
        return index;
    }
}