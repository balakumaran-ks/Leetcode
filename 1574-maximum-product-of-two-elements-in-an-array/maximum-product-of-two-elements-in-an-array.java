class Solution {
    public int maxProduct(int[] nums) {
        int max1 = 1;
        int max2 = 1;
        for(int num:nums){
            if(num>max1){
                max2=max1;
                max1 = num;
            }else if(num>max2){
                max2=num;
            }
        }
        return (--max1*--max2);
    }
}