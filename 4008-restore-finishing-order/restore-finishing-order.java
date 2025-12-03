class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
        Set<Integer> frdset = new HashSet<>();
        for(int f:friends) frdset.add(f);
        int[] ans = new int[friends.length];
        int i=0;
        for(int o:order)
        if(frdset.contains(o)) ans[i++]=o;
        return ans;
    }
}