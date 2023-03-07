class MyQueue {
    
    Stack<Integer> f = new Stack();
    Stack<Integer> s = new Stack();

    public MyQueue() {
        
    }
    
    public void push(int x) {
        if(f.isEmpty())
        {
            f.push(x);
        }
        else
        {
            while(!f.isEmpty())
            {
                s.push(f.pop());
            }
            s.push(x);
            while(!s.isEmpty())
            {
                f.push(s.pop());
            }
        }
        
    }
    
    public int pop() {
        if(!f.isEmpty())
            return f.pop();
        else
            return -1;
    }
    
    public int peek() {
        return f.peek();
        
    }
    
    public boolean empty() {
        return f.isEmpty() ;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */