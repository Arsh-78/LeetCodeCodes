class MinStack {
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> minEl = new Stack<Integer>();
    int min = Integer.MAX_VALUE;
    public MinStack() {
        
    }
    
    public void push(int val) {
     
        if(val<=min)
        {
            min=val;
        }
        
        stack.push(val);
        minEl.push(min);
    }
    
    public void pop() {
        
        if(stack.isEmpty())
        {
            min = Integer.MAX_VALUE;
        }
        
        if(min==minEl.peek())
        {
             stack.pop();
             minEl.pop();
            if(!minEl.isEmpty())
                min=minEl.peek();
            else
                min=Integer.MAX_VALUE;
        }
        else
        {
            stack.pop();
            minEl.pop();
        }
       
            
    }

    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minEl.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */