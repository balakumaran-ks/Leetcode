import java.util.*;
class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int totApp = sum(apple);
        int res=0;
        Arrays.sort(capacity);
        int i = capacity.length-1;
        while(totApp>0){
            totApp-=capacity[i--];
            res++;
        }
        return res;
    }
    public static int sum(int[] nums){
        int res=  0;
        for(int i=0;i<nums.length;i++)
        res+=nums[i];
        return res;
    }
}