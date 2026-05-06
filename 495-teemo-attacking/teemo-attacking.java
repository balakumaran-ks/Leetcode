class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0) return 0;
        
        int res = duration; // Start with the first attack's full duration
        int nextAttackTime = timeSeries[0] + duration;
        
        for (int i = 1; i < timeSeries.length; i++) {
            if (timeSeries[i] < nextAttackTime) {
                // If overlapping, only add the "extra" time this attack provides
                int overlap = nextAttackTime - timeSeries[i];
                res += (duration - overlap);
            } else {
                // If no overlap, add the full duration
                res += duration;
            }
            // Always update the next expiration time to: current start + duration
            nextAttackTime = timeSeries[i] + duration;
        }
        
        return res;
    }
}

/*
class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0) return 0;
        
        int totalSeconds = 0;
        for (int i = 0; i < timeSeries.length - 1; i++) {
            // Add the minimum of the actual gap or the duration
            totalSeconds += Math.min(timeSeries[i + 1] - timeSeries[i], duration);
        }
        
        // Always add the full duration for the very last attack
        return totalSeconds + duration;
    }
}
*/