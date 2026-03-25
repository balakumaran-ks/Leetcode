class Solution {
    int sumD(int n){
        int sum = 0;
        while(n!=0){
            int a = n%10;
            n/=10;
            a*=a;
            sum+=a;
        }
        return sum;
    }
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(n!=1){
            if(set.contains(n))return false;
            set.add(n);
            n = sumD(n);
        }
        return true;
    }
}