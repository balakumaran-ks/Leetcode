class Solution {
    public String convert(String s, int numRows) {
        int n = s.length();
        if(n<=numRows || numRows==1)return s;
        StringBuilder[] arr = new StringBuilder[numRows];
        for(int i=0;i<numRows;i++)arr[i]=new StringBuilder();
        int index = 0;
        int i = 0;
        while(index<n){
            while(index<n && i!=numRows){
                arr[i++].append(s.charAt(index++));
            }
            i-=2;
            while(index<n && i>=0){
                arr[i--].append(s.charAt(index++));
            }
            i+=2;
        }
        StringBuilder res = new StringBuilder();
        for(i=0;i<numRows;i++)res.append(arr[i].toString());
        return res.toString();
    }
}