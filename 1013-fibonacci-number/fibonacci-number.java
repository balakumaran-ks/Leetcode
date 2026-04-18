class Solution {
    int[] fibArr = {0,1,1,2,3,5,8,13,21,34,55,89,144,233,377,610};
    public int fib(int n) {
        if(n<fibArr.length)return fibArr[n];
        return fib(n-1)+fib(n-2);
    }
}