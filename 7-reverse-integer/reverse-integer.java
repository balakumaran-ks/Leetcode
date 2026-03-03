class Solution {
    public int reverse(int x) {
        int max = 2147483647;
        int min = -2147483648;
        int rev=0;
        while(x!=0){
            if(rev>max/10||rev<min/10)return 0;
            rev = rev*10+x%10;
            x/=10;
        }
        return rev;
    }
}
