
class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) return n;
        
        int maxPoints = 0;
        
        // Treat each point as an anchor
        for (int i = 0; i < n; i++) {
            // Map to store slope as a string "dy/dx" -> count of points
            Map<String, Integer> slopeMap = new HashMap<>();
            int duplicate = 1; // Tracks the anchor point itself
            int currentMax = 0;
            
            for (int j = i + 1; j < n; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];
                
                // Handle duplicate points
                if (dx == 0 && dy == 0) {
                    duplicate++;
                    continue;
                }
                
                // Reduce the slope fraction by finding the Greatest Common Divisor (GCD)
                // This avoids floating-point precision issues
                int gcd = gcd(dx, dy);
                dx /= gcd;
                dy /= gcd;
                
                // Standardize the sign so that (-1/-2) and (1/2) are treated the same
                if (dx < 0) {
                    dx = -dx;
                    dy = -dy;
                } else if (dx == 0) {
                    // Vertical line representation standard
                    dy = Math.abs(dy);
                }
                
                String slope = dy + "/" + dx;
                slopeMap.put(slope, slopeMap.getOrDefault(slope, 0) + 1);
                currentMax = Math.max(currentMax, slopeMap.get(slope));
            }
            
            // Total points on the best line passing through the anchor point i
            maxPoints = Math.max(maxPoints, currentMax + duplicate);
        }
        
        return maxPoints;
    }
    
    // Helper method to find the greatest common divisor
    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}