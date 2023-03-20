class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();
        int i=0;
        boolean ans = false;
        if(s.length()==0)
        {
            return true;
        }
        while(i<s.length())
        {
            if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='[')
            {
                st.push(s.charAt(i));
            }
            
            else
            {
                if(st.isEmpty())
                {
                    return false;
                }
                if(st.pop() != matchingp(s.charAt(i)) )
                {
                    return false;
                }
                else
                {
                    ans = true;
                }
            }
            i++;
        }
        if(!st.isEmpty())
        {
            return false;
        }
        return ans;
        
    }
    
    char matchingp(char t)
    {
        if(t==')')
        {
            return '(';
        }
        else if(t=='}')
        {
            return '{';
        }
        else
        {
            return '[';
        }
    }
}