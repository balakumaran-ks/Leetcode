class Solution {
    public int countPartitions(int[] nums) {
        int sum1=0,sum2=0,ans=0;
        for(int n:nums)sum2+=n;
        for(int n:nums){
            sum1+=n;
            sum2-=n;
            if((sum1-sum2)%2==0)ans+=1;
        }
        return ans>0?ans-1:0;
    }
}