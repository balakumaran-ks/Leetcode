class Solution {
    public int[] minOperations(String boxes) {
        char[] box = boxes.toCharArray();
        int[] ans = new int[box.length];
        Arrays.fill(ans,0);
        for(int i=0;i<box.length;i++)
        for(int j=0;j<box.length;j++)
        if(box[j]=='1')
        ans[i]+=Math.abs(i-j);
        return ans;
    }
}