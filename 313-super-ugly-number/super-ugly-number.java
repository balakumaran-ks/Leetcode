class Solution {
    //own code derived from coffee and ugly number editorial from leetcode (i first solved ugly numbers on my own)
    public int nthSuperUglyNumber(int n, int[] primes) {
        long[] uglyNums = new long[n];
        int[] primeId = new int[primes.length];
        long[] nextMul = new long[primes.length];
        for(int i=0;i<primes.length;i++)nextMul[i]=(long)primes[i];
        uglyNums[0] = 1;
        for(int i=1;i<n;i++){
            long next = Arrays.stream(nextMul).min().getAsLong();
            uglyNums[i] = next;
            for(int j=0;j<nextMul.length;j++){
                if(nextMul[j]==next)primeId[j]+=1;
                nextMul[j] = uglyNums[primeId[j]]*primes[j];
            }

        }
        return (int)uglyNums[n-1];
    }
}