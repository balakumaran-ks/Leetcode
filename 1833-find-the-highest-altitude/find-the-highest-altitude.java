class Solution {
    public int largestAltitude(int[] gain) {
        int[] prefix = new int[gain.length+1];
        for(int i=1;i<prefix.length;i++){
            prefix[i] = prefix[i-1]+gain[i-1];
        }
        int max = Integer.MIN_VALUE;
        for(int n:prefix){
            if(n>max)max=n;
        }
        return max;
    }
}