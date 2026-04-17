class Solution {
    public static int reverse(int n){
        int res = 0;
        while(n!=0){
            res = res*10+n%10;
            n/=10;
        }
        return res;
    }

    public int minMirrorPairDistance(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int res = -1;
        for(int ind=0;ind<nums.length;ind++){
            if(map.containsKey(nums[ind])){
                if(res==-1)res = Math.abs(ind-map.get(nums[ind]));
                else{
                    res = Math.abs(ind-map.get(nums[ind]))<res?Math.abs(ind-map.get(nums[ind])):res;
                }
                map.put(reverse(nums[ind]),ind);
            }else{
                map.put(reverse(nums[ind]),ind);
            }
        }
        return res;
    }
}