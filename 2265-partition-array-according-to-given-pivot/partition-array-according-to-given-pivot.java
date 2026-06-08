class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        ArrayList<Integer> small = new ArrayList<>();
        ArrayList<Integer> large = new ArrayList<>();
        int size = nums.length;
        for(int num:nums){
            if(num<pivot)small.add(num);
            else if(num>pivot)large.add(num);
        }
        int index = 0;
        for(int num:small)nums[index++] = num;
        for(int i=0;i<(size - (small.size()+large.size()));i++)nums[index++]=pivot;
        for(int num:large)nums[index++]=num;
        return nums;
    }
}