class MinStack {

    ArrayList<Integer> stack;
    PriorityQueue<Integer> minHeap;

    public MinStack() {
        stack = new ArrayList<>();
        minHeap = new PriorityQueue<>();
    }
    
    public void push(int value) {
        stack.add(value);
        minHeap.add(value);
    }
    
    public void pop() {
        Integer res = stack.get(stack.size()-1);
        stack.remove(stack.size()-1);
        minHeap.remove(res);
        // return res;
    }
    
    public int top() {
        return stack.get(stack.size()-1);
    }
    
    public int getMin() {
        return minHeap.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */