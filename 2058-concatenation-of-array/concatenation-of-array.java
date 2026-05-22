class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] res = new int[2*n];
        for(int iter=0;iter<n;iter++){
            res[iter]=nums[iter];
            res[iter+n]=nums[iter];
        }
        return res;
    }
}