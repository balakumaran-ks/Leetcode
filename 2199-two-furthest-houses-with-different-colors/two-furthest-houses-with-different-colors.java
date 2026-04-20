class Solution {
    public int maxDistance(int[] colors) {
        //traverse the array and find the occurences of each different colors
        //save the maximum distance
        //return the maximum distance
        int n = colors.length;
        int res = 0;
        if(colors[0]!=colors[n-1])return n-1;
        for(int i=0;i<n;i++){
            if(colors[i]!=colors[0]||colors[i]!=colors[n-1])
            res = Math.max(res,Math.max(i,n-i-1));
        }
        return res;
    }

}