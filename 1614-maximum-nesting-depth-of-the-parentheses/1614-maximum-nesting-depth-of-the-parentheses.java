class Solution {
    public int maxDepth(String s) {
        Stack<Character> st = new Stack<>();
        int depth=0;
        
        
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
            {
                st.push('(');   
            }
            else if(s.charAt(i)==')')
            {
                st.pop();
            }
            else
            {
                continue;
            }
            
            depth = Math.max(depth,st.size());
        }
        
        return depth;
    }
}