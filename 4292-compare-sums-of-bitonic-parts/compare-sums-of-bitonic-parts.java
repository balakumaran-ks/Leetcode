class Solution {
    public int compareBitonicSums(int[] nums) {
        int res;
        int n = nums.length;
        long first_part = 0L;
        long second_part = 0L;
        long last_element = -1;
        int ind = 0;
        for(int i=0;i<n;i++){
            if(nums[i]>last_element){
                first_part+=nums[i];
                last_element = nums[i];
                ind = i;
            }else break;
        }
        for(int i=ind;i<n;i++)
        second_part+=nums[i];
        if(first_part>second_part)res=0;
        else if(first_part<second_part)res=1;
        else res = -1;
        return res;
    }
}