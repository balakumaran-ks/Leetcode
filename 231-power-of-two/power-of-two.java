class Solution {
    public boolean isPowerOfTwo(int n) {
        //edge case 
        if(n==0 || n<0)return false;
        return (n&(n-1))==0;
    }
}