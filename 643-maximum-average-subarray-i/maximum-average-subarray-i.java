class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        double avg = 0;
        double res = Integer.MIN_VALUE;
        double div = (double)k;

        //first window
        for(int i=0;i<k;i++)sum+=(double)nums[i];
        avg = sum/div;
        res = Math.max(avg,res);

        //sliding window
        for(int i=k;i<nums.length;i++){
            sum-=nums[i-k];
            sum+=nums[i];
            avg = sum/div;
            res = Math.max(res,avg);
        }

        return res;
    }
}