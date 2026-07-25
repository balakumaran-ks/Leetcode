class Solution {
    public int maxProduct(int n) {
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        while(n!=0){
            pq.add(n%10);
            n/=10;
        }
        return pq.poll()*pq.poll();
    }
}