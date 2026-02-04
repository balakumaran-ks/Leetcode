class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> pairs = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            int num = nums[i];
            if(pairs.containsKey(target-num)){
                return new int[] {pairs.get(target-num)+1,i+1};
            }
            pairs.put(num,i);
        }
        return new int[] {};
    }
}