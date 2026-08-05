class Solution {
    public String convert(String s, int numRows) {
        int n = s.length();
        if(n<=numRows || numRows==1)return s;
        char[][] matrix = new char[numRows][n];
        int index = 0;
        int i=0;
        int j=0;
        while(index<n){
            while(index<n && i!=numRows){
                matrix[i][j] = s.charAt(index);
                index++;
                i++;
            }
            i-=2;
            while(index<n && i>=0){
                matrix[i--][++j]=s.charAt(index);
                index++;
                // if(i>=0)j++;
            }
            i+=2;
        }
        // for(char[] arr:matrix)System.out.println(Arrays.toString(arr));
        StringBuilder sb = new StringBuilder();
        for(char[] arr:matrix){
            for(char c:arr){
                if(c=='.'||c==','||(c>='a'&&c<='z')||(c>='A'&&c<='Z'))sb.append(c);
            }
        }
        return sb.toString();
    }
}