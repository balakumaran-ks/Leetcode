class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int left,right;
        left = 0;
        right = height.length-1;
        int temp = 0;
        while(left<right){
            temp = (right-left)*Math.min(height[left],height[right]);
            max = max>temp?max:temp;
            if(height[left]>height[right])right--;
            else left++;
        }
        return max;
    }
}