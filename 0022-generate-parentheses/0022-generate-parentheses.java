class Solution {
    public List<String> generateParenthesis(int n) {
        
        ArrayList<String> temp = new ArrayList();
        return helper(n,"",temp);    
    }
    
    public List<String> helper(int n ,String s,List<String> ans)
    {
        if(s.length()>2*n)
        {
            return ans;
        }
        if(s.length()==2*n)
        {
            if(isValid(s))
            {
                ans.add(s);
            }
            return ans;
        }
        helper(n,s+"(",ans);
        helper(n,s+")",ans);
        return ans;
              
    }
    
    public boolean isValid(String s)
    {
        Stack<Character> st = new Stack<>();
        
        int i=0;
        while(i<s.length())
        {
            if(s.charAt(i)=='(')
            {
                st.push(s.charAt(i));
                i++;
            }
            else
            {
                if(!st.isEmpty())
                {
                    st.pop();
                    i++;
                }
                else
                {
                    return false;
                }
            }
                
        }
        
        if(i==s.length() && st.isEmpty())
        {
            return true;
        }
        return false;
    }
}