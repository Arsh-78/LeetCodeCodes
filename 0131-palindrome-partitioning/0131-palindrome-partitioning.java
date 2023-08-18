class Solution {
    public List<List<String>> partition(String s) {
        
        List<List<String>> ans = new ArrayList<>();
        List<String> p = new ArrayList<String>();
        
        helper(0,s,p,ans);
        
        return ans;
    }
    
    public void helper(int ind,String s,List<String> p , List<List<String>> ans)
    {
        if(ind==s.length())
        {
            ans.add(new ArrayList<>(p));
            return;
        }
        
        for(int i=ind ;i<s.length();i++)
        {
            if(isPalin(s,ind,i))
            {
                p.add(s.substring(ind,i+1));
                helper(i+1,s,p,ans);
                p.remove(p.size()-1);
            }
        }
       
        
    }
    
    boolean isPalin(String s,int start,int end)
    {
        while(start<=end)
        {
            if(s.charAt(start) != s.charAt(end))
            {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}