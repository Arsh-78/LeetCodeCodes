class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        
        Stack<Integer> st = new Stack<Integer>();
        
        int i=0;
        int j=0;
        
        while(j<popped.length && i<pushed.length)
        {
            if(popped[j] == pushed[i])
            {
                j++;
                i++;
                
            }
            else
            {
                if(!st.isEmpty())
                {
                    if(st.peek()==popped[j])
                    {
                        System.out.println(st.pop());
                        j++;
                    }
                    else
                    {
                        
                        st.push(pushed[i]);
                        i++;
                    }
                }
                else
                {
                    st.push(pushed[i]);
                    i++;
                }
                
            }
        }
        while(j<popped.length && !st.isEmpty())
        {
            
            if(st.peek()==popped[j])
            {
                System.out.println(st.pop());
                
            }
            j++;
        }
        if(i==pushed.length && j==popped.length && st.isEmpty())
        {
            return true;
        }
        return false;
    }
}