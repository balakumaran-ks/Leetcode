class Solution {
    public boolean isPowerOfTwo(int n) {
        //edge case 
        if(n==0)return false;

        //positive number
        if(n>0){
            return (n&(n-1))==0;
        }

        return false;
    }
}