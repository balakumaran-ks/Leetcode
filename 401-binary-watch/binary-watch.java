class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> res = new ArrayList<>();
        for(int hour=0;hour<12;hour++){
            for(int minute=0;minute<60;minute++){
                int bits = Integer.bitCount(hour)+Integer.bitCount(minute);
                if(bits==turnedOn){
                    StringBuilder sb = new StringBuilder();
                    sb.append(hour);
                    sb.append(":");
                    if(minute<10)sb.append('0');
                    sb.append(minute);
                    res.add(sb.toString());
                }
            }
        }
        return res;
    }
}