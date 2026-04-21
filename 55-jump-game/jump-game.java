class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int[] possible = new int[n];
        possible[0] = 1;
        for(int i=0;i<n;i++){
            if(possible[i]==1){
                int jumps = nums[i];
                for(int j=0;j<=jumps && j+i < n;j++){
                    possible[j+i] = 1;
                }
            }else{
                continue;
            }
        }
        return possible[n-1]==1;
    }
}