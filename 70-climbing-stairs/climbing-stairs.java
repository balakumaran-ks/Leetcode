class Solution {
    public int climbStairs(int n) {
        if(n==1)return 1;
        if(n==2)return 2;
        int prev = 1;//first stair
        int curr = 2;//second stair
        for(int i=3;i<=n;i++){
            int res = prev+curr;
            prev = curr;
            curr = res;
        }
        return curr;
    }
}