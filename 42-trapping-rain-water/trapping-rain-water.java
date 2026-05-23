class Solution {
    public int trap(int[] height) {
    int l = 0, r = height.length - 1;
    int maxL = 0, maxR = 0, water = 0;
    while (l <= r) {
        if (maxL <= maxR) {
            maxL = Math.max(maxL, height[l]);
            water += maxL - height[l];
            l++;
        } else {
            maxR = Math.max(maxR, height[r]);
            water += maxR - height[r];
            r--;
        }
    }
    return water;
}
}