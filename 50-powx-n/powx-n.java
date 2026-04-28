class Solution {
    public double myPow(double x, int n) {
        long y = n;   // convert first

        // for n is negative.
        if(y < 0){
            x = 1.0 / x;  
            y = - y;  
        }
        double ans = 1;

        // finding the ans.
        while (y > 0) {
            if (y % 2 == 1) {

                ans = ans * x;
            }

            x = x * x;
            y = y / 2;
        }

        return ans;
    }
}