class Solution {
    public boolean isPowerOfTwo(int n) {
        int ans=0;
        for(char a:Integer.toBinaryString(n).toCharArray())
        if(a=='1')ans++;
        return ans==1&&n>0;
    }
}