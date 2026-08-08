class Solution {
    private boolean canEatAll(int[] piles, int speed, int h) {
        long totalHours = 0;
        for (int banana : piles) {
            totalHours += (banana + speed - 1) / speed; 
            if(totalHours>h)return false;
        }
        return true;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int searchLow = 1;
        int searchHigh = 0;
        for (int pile : piles) {
            searchHigh = Math.max(searchHigh, pile);
        }

        while (searchLow < searchHigh) {
            int mid = searchLow + (searchHigh - searchLow) / 2;
            if (canEatAll(piles, mid, h)) {
                searchHigh = mid; 
            } else {
                searchLow = mid + 1; 
            }
        }
        return searchLow;
    }
}