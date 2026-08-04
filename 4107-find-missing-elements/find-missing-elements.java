class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        List<Integer> res = new ArrayList<>();
        for(int num:nums){
            if(num<min)min=num;
            if(num>max)max=num;
            set.add(num);
        }    
        for(int i=min;i<=max;i++)if(!set.contains(i))res.add(i);
        return res;
    }
}