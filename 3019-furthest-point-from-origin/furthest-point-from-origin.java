class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int m1=0;
        int m2 = 0;
        //by changing _ to R
        for(int i=0;i<moves.length();i++){
            if(moves.charAt(i)=='R'||moves.charAt(i)=='_')m1++;
            else m1--;
        }

        //by changing _ to L
        for(int i=0;i<moves.length();i++){
            if(moves.charAt(i)=='L'||moves.charAt(i)=='_')m2++;
            else m2--;
        }

        return Math.max(m1,m2);
    }
}