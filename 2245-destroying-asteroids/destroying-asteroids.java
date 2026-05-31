class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long sum = (long)mass;
        for(int a:asteroids){
            if((long)a<=sum)sum+=(long)a;
            else return false;
        }
        return true;
    }
}