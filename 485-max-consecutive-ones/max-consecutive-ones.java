class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res=0;
        int cnt=0;
        for(int num:nums){
            if(num==1){
                cnt++;
            }else{
                res = res>cnt?res:cnt;
                cnt=0;
            }
        }
        res = res>cnt?res:cnt;
        return res;
    }
}