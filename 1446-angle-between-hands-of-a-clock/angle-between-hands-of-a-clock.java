class Solution {
    public double angleClock(int hour, int minutes) {
        hour = hour%12;
        double hourdegree = hour*30;
        hourdegree += (minutes/2.0);
        double mindeg = minutes*6;
        return Math.min(Math.abs(hourdegree-mindeg),360-Math.abs(hourdegree-mindeg));
    }
}