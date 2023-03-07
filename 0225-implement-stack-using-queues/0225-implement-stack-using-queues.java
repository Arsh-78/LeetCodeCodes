class MyStack {
    
    Queue<Integer> q1 = new LinkedList();
    Queue<Integer> q2 = new LinkedList();
    

    public MyStack() {
        
    }
    
    public void push(int x) {
        
        q1.add(x);
        while(!q2.isEmpty())
        {
            q2.remove();
        }
        q2.add(x);
        
    }
    
    public int pop() {
        if(q1.isEmpty())
        {
            return -1;
        }
        while(!q2.isEmpty())
        {
            q2.remove();
        }
        while(q1.size()>1)
        {
            q2.add(q1.remove());
        }
        int temp = q1.remove();
        while(!q2.isEmpty())
        {
            if(q2.size()==1)
            {
                q1.add(q2.peek());
                break;
            }
            q1.add(q2.remove());
            
        }
        
        
        return temp;
    }
    
    public int top() {
        if(q2.isEmpty())
        {
            return -1;
        }
        return q2.peek();
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */