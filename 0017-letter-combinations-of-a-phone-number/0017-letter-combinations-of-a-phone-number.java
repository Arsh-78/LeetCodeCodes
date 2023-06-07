class Solution {
    public List<String> letterCombinations(String digits) {
      
        HashMap<Integer,String> map = new HashMap<>();
        String t = "abcdefghijklmnopqrstuvwxyz";
        ArrayList<String> ans = new ArrayList<>();
        if(digits.length()==0)
        {
            return ans;  //If no keys passed
        }
        int counter =0;
        for(int i=2;i<=9;i++)  //Making a Hashed Table for Key combinations
        {
            if(i==9)
            {
                map.put(i,t.substring(counter));
            }
            else if(i==7)
            {
                 map.put(i,t.substring(counter,counter+4));
                counter=counter+4;
            }
            else
            {
                map.put(i,t.substring(counter,counter+3));
                counter=counter+3;
            }
        }
    
        helper("",digits,digits,map,ans); //helper explained in description
        System.out.println(ans);
        
        return ans;
    }

    void helper(String p,String up,String digits,HashMap<Integer,String> map,ArrayList<String> ans)
    {
        if(p.length()==digits.length())
        {
            ans.add(p);
        }
        if(up.length()==0)
        {
            return;
        }
        else
        {
            String temp=map.get(up.charAt(0)-'0');
            for(int i=0;i<temp.length();i++)
            {
                helper(p+temp.charAt(i),up.substring(1),digits,map,ans);
            }

        }
    }
    
}