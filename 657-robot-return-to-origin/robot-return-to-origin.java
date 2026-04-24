class Solution {
    public boolean judgeCircle(String moves) {
        //starting 0,0 on a 2D plane
        //given sequence => does the last place is origin ?

        //intuition => if the total horizontal displacement == 0 and
        //             the total vertical displacement == 0 
        //             the robot will stand at the starting position (0,0)

        int horizontal = 0; // horizontal displacement
        int vertical = 0;   // vertical displacement

        for(int ind=0;ind<moves.length();ind++){
            char move = moves.charAt(ind);
            if(move=='R')horizontal++;
            else if(move=='L')horizontal--;
            else if(move=='U')vertical++;
            else vertical--;
        }
        return horizontal==0 && vertical==0;
    }
}