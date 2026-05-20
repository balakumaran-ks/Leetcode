class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] res = new int[A.length];
        HashSet<Integer> s1 = new HashSet<>();
        HashSet<Integer> s2 = new HashSet<>();
        int com = 0;
        for(int i=0;i<A.length;i++){
            int el1 = A[i];
            int el2 = B[i];
            s1.add(el1);
            s2.add(el2);
            if(s1.contains(el2)){
                com++;
            }
            if(s2.contains(el1)){
                com++;
            }
            if(el1==el2)com--;
            res[i] = com;
        }
        return res;
    }
}