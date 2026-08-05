class Solution {
    public String convert(String s, int numRows) {
        int n = s.length();
        if(n<=numRows || numRows==1)return s;
        String[] arr = new String[numRows];
        for(int i=0;i<numRows;i++)arr[i]="";
        int index = 0;
        int i = 0;
        while(index<n){
            while(index<n && i!=numRows){
                arr[i++]+=s.substring(index++,index);
            }
            i-=2;
            while(index<n && i>=0){
                arr[i--]+=s.substring(index++,index);
            }
            i+=2;
        }
        StringBuilder res = new StringBuilder();
        for(i=0;i<numRows;i++)res.append(arr[i]);
        return res.toString();
    }
}