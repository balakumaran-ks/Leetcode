class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        for(int i=1;i<=n;i++){
            int cpy= i;
            while(cpy!=0){
                if((cpy&1)==1)res[i]++;
                cpy = cpy>>1;
            }
        }
        return res;
    }
}