class Solution {
    public String simplifyPath(String path) {
    
        Stack<String> st = new Stack<String>();
        int i=1;
        int n = path.length();
        String temp= "";
        while(i<n)
        {
            if(path.charAt(i)!='/')
            {
                temp += path.charAt(i);
                i++;
            }
            else
            {
                if(temp.equals("."))
                {
                    i++;
                    temp="";
                }
                else if(temp.equals(".."))
                {
                    if(!st.isEmpty())
                        st.pop();
                    
                    temp="";
                    i++;
                }
                else
                {
                    System.out.println(temp);
                    if(!temp.equals(""))
                    {
                        st.push(temp);
                    }
                    temp="";
                    i++;
                }
            }
        }
        
            if(temp.equals("..") && !st.isEmpty())
            {
                st.pop();
            }
            else if(temp.equals("."))
            {
                
            }
            else
            {
                if(!temp.equals(".."))
                    st.push(temp);
            }
        
        Stack<String> rev=new Stack<String>();
        
        while(!st.isEmpty())
        {
            rev.push(st.pop());
        }
       String ans="";
        ans += "/";
        while(!rev.isEmpty())
        {
            if(rev.peek().equals(""))
            {
                rev.pop();
            }
            else
            {
                ans += rev.pop() + "/";
            }
        }
        
        while(ans.charAt(ans.length()-1)=='/' && ans.length()>1)
        {
            ans = ans.substring(0,ans.length()-1);
        }
        System.out.println(ans);
        return ans;
    }
}