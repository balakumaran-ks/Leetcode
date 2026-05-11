class Solution {
    public int[] separateDigits(int[] nums) {
        StringBuilder sb = new StringBuilder();
        for(int num:nums)sb.append(num);
        int[] visited = new int[10];
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<sb.length();i++){
            // if(visited[sb.charAt(i)-'0']==0){
            //     visited[sb.charAt(i)-'0'] = 1;
            //     ans.append(sb.charAt(i));
            // }
            ans.append(sb.charAt(i));
        }
        int[] res = new int[ans.length()];
        for(int i=0;i<res.length;i++){
            res[i] = Integer.parseInt(Character.toString(ans.charAt(i))); 
        }
        return res;
    }
}