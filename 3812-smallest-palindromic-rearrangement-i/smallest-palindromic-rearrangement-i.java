class Solution {
    public String smallestPalindrome(String s) {
        Queue<Character> pq = new PriorityQueue<>();
        int i = 0;
        for(;i<s.length()/2;i++)pq.add(s.charAt(i));
        if(pq.size()*2==s.length()){
            StringBuilder sb = new StringBuilder();
            while(!pq.isEmpty())sb.append(pq.poll());
            return sb.toString()+sb.reverse().toString();
        }else{
            StringBuilder sb = new StringBuilder();
            while(!pq.isEmpty())sb.append(pq.poll());
            String res = sb.toString();
            res+=Character.toString(s.charAt(i));
            return res+sb.reverse().toString();
        }

    }
}