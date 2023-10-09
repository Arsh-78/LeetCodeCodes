class MyQueue {
    Stack<Integer> st1 = new Stack<>();
    Stack<Integer> st2 = new Stack<>();
    int top=-1;

    public MyQueue() {
        
    }
    
    public void push(int x) {

        if(st1.isEmpty())
        {
            st1.push(x);
            top = x;
        }
            
        else
        {

            while(!st1.isEmpty())
            {
                st2.push(st1.peek());
                st1.pop();
            }
            st2.push(x);
            while(!st2.isEmpty())
            {
                st1.push(st2.peek());
                st2.pop();
            }
        }
    }
    
    public int pop() {
        int temp = top;
        st1.pop();
        if(st1.isEmpty())
            top=-1;
        else
            top=st1.peek();
        return temp;
    }
    
    public int peek() {

     return top;   
    }
    
    public boolean empty() {
        return st1.isEmpty();
        
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