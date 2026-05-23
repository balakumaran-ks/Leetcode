class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int r = nums.length-1;
        int l = 0;
        int pos = r;
        while(l<=r){
            if((nums[l]*nums[l])>(nums[r]*nums[r])){
                res[pos--]=(nums[l]*nums[l]);
                l++;
            }else{
                res[pos--]=(nums[r]*nums[r]);
                r--;
            }
        }
        return res;
    }
}