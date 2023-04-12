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
        
                   System.out.println(temp);
         
            if(temp.equals("..") && !st.isEmpty())
            {
                st.pop();
            }
            else if(temp.equals("."))
            {
                
            }
            else
            {
                if(!temp.equals("..") && !temp.equals(""))
                    st.push(temp);
            }
        
       
       String ans="";
        while(!st.isEmpty())
        {
            if(st.size()==1)
                ans=st.pop()+ans;
            
            else
            {
                ans ="/"+st.pop() +ans;
            }
        }
        
        
        System.out.println(ans);
        return "/"+ans;
    }
}